from datetime import date


class FlightService:
    def search_flights(
        self, start_date: date, end_date: date | None, origin: str, destination: str
    ):
        return [
            {
                'airline': 'Avianca',
                'flight_number': 'AV123',
                'origin': origin,
                'destination': destination,
                'departure': start_date,
                'arrival': end_date,
            }
        ]
