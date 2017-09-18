package main.java.com.javatunes.util;

import java.util.Date;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;

public class MusicItem
implements java.io.Serializable
{
   private static final long serialVersionUID = 1L;

   // properties
   private Long       m_id;
   private String     m_title;
   private String     m_artist;
   private Date       m_releaseDate;
   private BigDecimal m_listPrice;
   private BigDecimal m_price;

   private static SimpleDateFormat c_dateFormatter = new SimpleDateFormat("yyyy-MM-dd");

   public MusicItem() { }

   public MusicItem(Long id)
   {
      this.setId(id);
   }

   public MusicItem(Long id, String title, String artist,
                    Date releaseDate, BigDecimal listPrice, BigDecimal price)
   {
      this.setId(id);
      this.setTitle(title);
      this.setArtist(artist);
      this.setReleaseDate(releaseDate);
      this.setListPrice(listPrice);
      this.setPrice(price);
   }

   public Long getId() { return m_id; }
   public String getTitle() { return m_title; }
   public String getArtist() { return m_artist; }
   public Date getReleaseDate() { return m_releaseDate; }
   public BigDecimal getListPrice() { return m_listPrice; }
   public BigDecimal getPrice() { return m_price; }

   public String getReleaseDateString() {
      String result = null;
      Date releaseDate = this.getReleaseDate();
      
      if (releaseDate != null)
      {
         result = c_dateFormatter.format(releaseDate);
      }
      return result;
   }   
   
   public void setId			(Long id) { m_id = id; }
   public void setTitle			(String title) { m_title = title; }
   public void setArtist		(String artist) { m_artist = artist; }
   public void setReleaseDate	(Date releaseDate) { m_releaseDate = releaseDate; }
   public void setListPrice		(BigDecimal listPrice) { m_listPrice = listPrice; }
   public void setPrice			(BigDecimal price) { m_price = price; }

   // override Object.equals
   public boolean equals(Object compare)
   {
      boolean result = false;
      MusicItem other = null;

      if (compare instanceof MusicItem)
      {
         // cast to MusicItem
         other = (MusicItem) compare;

         // if all the fields are equal, the objects are equal
         result = other.getId().equals(this.getId()) &&
                  other.getTitle().equals(this.getTitle()) &&
                  other.getArtist().equals(this.getArtist()) &&
                  other.getReleaseDate().equals(this.getReleaseDate()) &&
                  other.getListPrice().compareTo(this.getListPrice()) == 0 &&
                  other.getPrice().compareTo(this.getPrice()) == 0;
      }
      return result;
   }

   // override Object.toString
   public String toString()
   {
      return this.getClass().getName() +
         ": id=" + this.getId() +
         " title=" + this.getTitle() +
         " artist=" + this.getArtist() +
         " releaseDate=" + this.getReleaseDate() +
         " listPrice=" + this.getListPrice() +
         " price=" + this.getPrice();
   }
}
