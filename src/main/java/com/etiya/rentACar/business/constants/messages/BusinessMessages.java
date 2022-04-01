package com.etiya.rentACar.business.constants.messages;

public class BusinessMessages {

    public class MaintenanceMessages {
        public static final String CAR_UNDERMAINTENANCE = "Bu araç bakımda";
    }

    public class RentalMessages {
        public static final String CAR_RENTED = "Bu araç kirada";
        public static final String CAR_NOT_AVAILABLE = " Araç müsait değil";
        public static final String RENTAL_NOT_ID = "Bu id ile bir kiralama gerçekleşmemiştir";
        public static final String RENTAL_DELETED = "Kiralama kaydı silinmiştir.";
        public static final String RENTAL_UPDATE = "Kiralama kaydı güncellenmiştir";
        public static final String RENTAL_ADD  ="Kiralama başarıyla eklenmiştir";
    }

    public class CityMessages {
        public static final String CITY_ADD = "şehir eklendi.";
    }


}
