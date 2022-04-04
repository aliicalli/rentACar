package com.etiya.rentACar.business.constants.messages;

public class BusinessMessages {

    public class MaintenanceMessages {
        public static final String CAR_UNDERMAINTENANCE = "Bakıma almak istediğiniz araç şu an zaten bakımda!";
        public static final String MAINTENANCE_ADD = "Araç bakım ekleme işlemi başarıyla gerçekleşti";
        public static final String MAINTENANCE_DELETED = "Araç bakım silme işlemi başarıyla gerçekleşti";
        public static final String MAINTENANCE_UPDATED = "Araç bakım güncelleme işlemi başarıyla gerçekleşti";
    }

    public class RentalMessages {
        public static final String CAR_RENTED = "Bu araç kirada";
        public static final String CAR_NOT_AVAILABLE = " Araç kiralanmak için müsait değil";
        public static final String RENTAL_RETURNED = "Kiralanan araç başarıyla teslim alınmıştır!";
        public static final String RENTAL_DELETED = "Kiralama kaydı silinmiştir.";
        public static final String RENTAL_UPDATE = "Kiralama kaydı güncellenmiştir";
        public static final String RENTAL_ADD = "Kiralama başarıyla eklenmiştir";
        public static final String RENTAL_NOT_EXIST = "Böyle bir id ile daha önce bir  kiralanma işlemi yoktur. Dolayısıyla teslim alınma söz konusu olamaz!";
    }

    public class CityMessages {
        public static final String CITY_ADD = "şehir eklendi.";
        public static final String  CITY_DELETED = "şehir silme işlemi başarıyla gerçekleşti";
        public static final String CITY_UPDATED = "Şehir güncelleme işlemi başarıyla gerçekleşti";
    }

    public class BrandMessages {
        public static final String BRAND_EXIST = " bu marka daha önce kullanılmış";
        public static final String BRAND_DELETED = "Marka başarıyla silindi";
        public static final String BRAND_ADDED = "Marka ekleme işlemi başarıyla gerçekleşti";
        public static final String BRAND_UPDATED = "Marka güncelleme işlemi başarılya gerçekleşti";
    }

    public class ColorMessages {
        public static final String COLOR_EXIST = " bu renk daha önce kullanılmıştır";
        public static final String COLOR_ADD = "Renk ekleme işlemi başarıyla gerçekleşti";
        public static final String COLOR_UPDATED = "Renk güncelleme işlmei başarıya gerçekleşti";
        public static final String COLOR_DELETED = "Renk silme işlmei başarıyla gerçekleşti";
    }

    public class AdditionalServiceMessages {
        public static final String ADDITIONAL_SERVICE_ADD = "Ek hizmetler ekleme işlemi başarıyla gerçekleşti";
        public static final String ADDITIONAL_SERVICE_DELETED = "Ek hizmetler başaryıla silindi";
        public static final String ADDITIONAL_SERVICE_UPDATED = "Ek hizmelter başarıyla güncellendi";
    }

    public class CarMessages {
        public static final String CAR_ADDED = "Başarıyla eklendi";
        public static final String CAR_DELETED = "Başarıyla silindi";
        public static final String CAR_UPDATED = "Başarıyla güncellendi";
        public static final String CAR_STATE_UPDATED = "Araba Durumu güncellemesi başarıyla gerçekleşti";
    }

    public class CustomerMessages{
        public static final String CUSTOMER_ADD = "kullanıcı ekleme işlemi başarıyla eklendi";
        public static final String CUSTOMER_UPDATED = "KULLANICI GÜNCELLEME İŞMELİ BAŞARIYLA GERÇEKLEŞTİ";
        public static final String CUSTOMER_DELETED = "Kullanıcı silme işlemi başarıyla gerçekleşti";
    }

    public class DamageMessages{
        public static final String DAMAGE_ADD = "Araç hasarı ekleme başarıyla gerçekleşti";
        public static final String DAMAGE_UPDATED = "Araç hasarı güncelleme işlemi başarıyla gerçekleşti";
        public static final String DAMAGE_DELETED = "Araç hasarı silme başarıyla gerçekleşti";
    }

    public class OrderedAdditionalServiceMessages{
        public static final String OREDERED_ADDITIONAL_SERVICE_ADD = "Ek hizmetler şiparişi başarıyla eklendi";
        public static final String OREDERED_ADDITIONAL_SERVICE_DELETED = "Ek hizmetler siparişi başarıyla silindi";
        public static final String OREDERED_ADDITIONAL_SERVICE_UPDATED = "Ek hizmetler siparişi başarıyla güncellendi";
    }
    public class BillMessages{
        public static final String BILL_ADDED = "Fatura başarıyla eklendi";
        public static final String BILL_DELETED = "Fatıra başarıyla silindi";
        public static final String BILL_UPDATED = "Fatura başarıyla güncellendi";
    }
}
