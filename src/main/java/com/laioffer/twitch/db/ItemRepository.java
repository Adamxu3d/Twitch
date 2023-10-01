package com.laioffer.twitch.db;


import com.laioffer.twitch.db.entity.ItemEntity;
import org.springframework.data.repository.ListCrudRepository;


public interface ItemRepository extends ListCrudRepository<ItemEntity, Long> {
    /*
     * SELECT * FROM items WHERE twitch_id = ?
     * Try searching for the spring jdbc documentation on how to implement
     * you own API for retrieving data
     *
     * At the back end this is a sql query
     */

    ItemEntity findByTwitchId(String twitchId);

}
