from datetime import date

from pydantic import BaseModel


class Hotel(BaseModel):
    hotel_name: str
    city: str
    check_in: date
    check_out: date
    price_per_night: float
