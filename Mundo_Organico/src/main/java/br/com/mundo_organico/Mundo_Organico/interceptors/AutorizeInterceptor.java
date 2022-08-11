package br.com.mundo_organico.Mundo_Organico.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import br.com.mundo_organico.Mundo_Organico.models.User;

@Component
public class AutorizeInterceptor implements HandlerInterceptor {

    private final boolean CONTROLAR_ACESSO = true;

    private final String PAGINA_ACESSO_NEGADO = "/acesso-negado";

    private final String[] PAGINAS_ESTATICAS = {"/css", "/img", "js"};
    private final String[] PAGINAS_DESLOGADO = {"/", "/login", "/cadastro", "/esqueceu-senha", "/alterar-senha"};
    private final String[] PAGINAS_LOGADO = {"/sair", "/main-center", "/pedidos/{id}", "/historico", "/meus-dados", "/info-pessoa/{id}", "/credencial/{id}",
            "/updateuser-info", "/updateuser-credencial", "/frutas", "/verduras", "/hortalicas", "/temperos", "/pedido", "/compra", "/produto"};

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //return HandlerInterceptor.super.preHandle(request, response, handler);

        String urlRequisitada = request.getServletPath();
        User usuarioLogado = (User) request.getSession().getAttribute("logado");
        boolean estaLogado = false;

        if (usuarioLogado != null) {
            estaLogado = true;
        }

        if (!CONTROLAR_ACESSO) {
            return true;
        }

        for (String paginaLogado : PAGINAS_LOGADO) {
            if (urlRequisitada.contains(paginaLogado)) {
                if (estaLogado) {
                    return true;
                } else {
                    if (!urlRequisitada.equals("/") && !urlRequisitada.equals("/sair")) {
                        response.sendRedirect("/login?destino=" + urlRequisitada);
                        return false;
                    } else {
                        response.sendRedirect("/login");
                        return false;
                    }
                }
            }
        }

        for (String paginaDeslogado : PAGINAS_DESLOGADO) {
            if (urlRequisitada.equals(paginaDeslogado)) {
                if (!estaLogado) {
                    return true;
                } else {
                    response.sendRedirect("/main-center");
                    return false;
                }
            }
        }

        for (String paginaEstatica : PAGINAS_ESTATICAS) {
            if (urlRequisitada.contains(paginaEstatica)) {
                return true;
            }
        }

        return true;
    }
}
