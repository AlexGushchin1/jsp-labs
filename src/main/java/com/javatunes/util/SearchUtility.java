package main.java.com.javatunes.util;

import java.util.ArrayList;
import java.util.Collection;
import java.sql.Date;
import java.math.BigDecimal;

public class SearchUtility {

   // catalog of MusicItem objects
   private static Collection<MusicItem> c_catalog = new ArrayList<MusicItem>();

   // searches catalog by ID
   public static MusicItem findById(Long id)
   {
      // declare return value
      MusicItem result = null;

      // iterate through the catalog, looking for an ID match
	  for (MusicItem item : c_catalog) {
         if (item.getId().equals(id))
         {
            result = item;    // assign to return value
            break;            // found it - stop looping
         }
      }
      return result;
   }

   // searches catalog by String ID
   public static MusicItem findById(String id)
   {
      Long idLong = Long.decode(id);
      return findById(idLong);
   }
      
   // searches catalog by keyword on artist and title
   public static Collection<MusicItem> findByArtist(String keyword)
   {
      // declare return value
      Collection<MusicItem> result = new ArrayList<MusicItem>();

      // remove case sensitivity
      keyword = keyword.toLowerCase();

      // iterate through the catalog, looking for a keyword match
	  for (MusicItem item : c_catalog) {
         if (item.getArtist().toLowerCase().indexOf(keyword) != -1) {
            result.add(item);
         }
      }
      return result;
   }


   // searches catalog by keyword on artist and title
   public static Collection<MusicItem> findByKeyword(String keyword)
   {
      // declare return value
      Collection<MusicItem> result = new ArrayList<MusicItem>();

      // remove case sensitivity
      keyword = keyword.toLowerCase();

      // iterate through the catalog, looking for a keyword match
      for (MusicItem item : c_catalog) {
         if (item.getTitle().toLowerCase().indexOf(keyword) != -1 ||
             item.getArtist().toLowerCase().indexOf(keyword) != -1)
         {
            result.add(item);
         }
      }
      return result;
   }

   // loads catalog with data
   static
   {
      add(501, "Diva", "Annie Lennox", "1992-01-04", "17.97", "13.99");
      add(502, "Dream of the Blue Turtles", "Sting", "1985-02-05", "17.97", "14.99");
      add(503, "Trouble is...", "Kenny Wayne Shepherd Band", "1997-08-08", "17.97", "14.99");
      add(504, "Lie to Me", "Jonny Lang", "1997-08-26", "17.97", "14.99");
      add(505, "Little Earthquakes", "Tori Amos", "1992-01-18", "17.97", "14.99");
      add(506, "Seal", "Seal", "1991-08-18", "17.97", "14.99");
      add(507, "Ian Moore", "Ian Moore", "1993-12-05", "9.97", "9.97");
      add(508, "So Much for the Afterglow", "Everclear", "1997-01-19", "16.97", "13.99");
      add(509, "Surfacing", "Sarah McLachlan", "1997-12-04", "17.97", "13.99");
      add(510, "Hysteria", "Def Leppard", "1987-06-20", "17.97", "14.99");
      add(511, "A Life of Saturdays", "Dexter Freebish", "2000-12-06", "16.97", "12.99");
      add(512, "Human Clay", "Creed", "1999-10-21", "18.97", "13.28");
      add(513, "My, I'm Large", "Bobs", "1987-02-20", "11.97", "11.97");
      add(514, "So", "Peter Gabriel", "1986-10-03", "17.97", "13.99");
      add(515, "Big Ones", "Aerosmith", "1994-05-08", "18.97", "14.99");
      add(516, "90125", "Yes", "1983-10-16", "11.97", "11.97");
      add(517, "1984", "Van Halen", "1984-08-19", "11.97", "11.97");
      add(518, "Escape", "Journey", "1981-02-25", "11.97", "11.97");

   }

   private static void add(long id, String title, String artist,
                           String releaseDate, String listPrice, String price)
   {
      c_catalog.add(new MusicItem(new Long(id), title, artist,
                    Date.valueOf(releaseDate), new BigDecimal(listPrice), new BigDecimal(price)));
   }


}