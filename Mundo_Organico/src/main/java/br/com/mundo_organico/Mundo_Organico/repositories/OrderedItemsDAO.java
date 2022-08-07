package br.com.mundo_organico.Mundo_Organico.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.mundo_organico.Mundo_Organico.models.Ordered_Items;

@Repository
public interface OrderedItemsDAO extends JpaRepository<Ordered_Items, Integer> {
	
    @Query(
            value = "SELECT * FROM ordered_items u WHERE u.user_id = ?1",
            nativeQuery = true)
    List<Ordered_Items> findItemsByUser(Integer status);
    
    @Query(
            value = "SELECT * FROM ordered_items u WHERE u.request_id = ?1",
            nativeQuery = true)
    List<Ordered_Items> findItemsByRequest(Integer status);

}
