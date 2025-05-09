from datetime import date


class CarRentalService:
    def search_cars(self, city: str, start_date: date, end_date: date):
        return [
            {
                'company': 'Localiza',
                'car_model': 'Kia Rio',
                'city': city,
                'start_date': start_date,
                'end_date': end_date,
                'price_per_day': 40.0,
            }
        ]
