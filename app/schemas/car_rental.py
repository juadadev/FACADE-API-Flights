from datetime import date

from pydantic import BaseModel


class CarRental(BaseModel):
    company: str
    car_model: str
    city: str
    start_date: date
    end_date: date
    price_per_day: float
