from datetime import date

from pydantic import BaseModel


class Flight(BaseModel):
    airline: str
    flight_number: str
    origin: str
    destination: str
    departure: date
    arrival: date
