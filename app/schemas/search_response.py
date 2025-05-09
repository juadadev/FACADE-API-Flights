from pydantic import BaseModel

from app.schemas.car_rental import CarRental
from app.schemas.flight import Flight
from app.schemas.hotel import Hotel


class SearchResponse(BaseModel):
    flights: list[Flight]
    hotels: list[Hotel]
    cars: list[CarRental]
