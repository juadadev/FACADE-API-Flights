from datetime import date

from app.facade.car_rental_service import CarRentalService
from app.facade.flight_service import FlightService
from app.facade.hotel_service import HotelService
from app.schemas.car_rental import CarRental
from app.schemas.flight import Flight
from app.schemas.hotel import Hotel
from app.schemas.search_response import SearchResponse


class TravelFacade:
    def __init__(self):
        self.flight_service = FlightService()
        self.hotel_service = HotelService()
        self.car_rental_service = CarRentalService()

    def search_all(
        self, start_date: date, end_date: date, origin: str, destination: str
    ):
        flights = self.flight_service.search_flights(
            start_date=start_date,
            end_date=end_date,
            origin=origin,
            destination=destination,
        )
        hotels = self.hotel_service.search_hotels(origin, start_date, end_date)
        cars = self.car_rental_service.search_cars(origin, start_date, end_date)
        return SearchResponse(
            flights=[Flight(**f) for f in flights],
            hotels=[Hotel(**h) for h in hotels],
            cars=[CarRental(**c) for c in cars],
        )
