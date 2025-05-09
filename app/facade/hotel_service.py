from datetime import date


class HotelService:
    def search_hotels(self, city: str, check_in: date, check_out: date):
        return [
            {
                'hotel_name': 'Hotel Estelar',
                'city': city,
                'check_in': check_in,
                'check_out': check_out,
                'price_per_night': 100.0,
            }
        ]
