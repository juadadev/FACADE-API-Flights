from fastapi import Query
from fastapi.routing import APIRouter

from app.facade.booking_facade import TravelFacade
from app.schemas.search_response import SearchResponse
from app.utils.date_parser import DateParse

route_search_flights = APIRouter()


@route_search_flights.get('/search_flights', response_model=SearchResponse)
async def search_flights(
    start_date: str = Query(..., description='Formato: DD/MM/YYYY'),
    end_date: str = Query(..., description='Formato: DD/MM/YYYY'),
    origin: str = Query(...),
    destination: str = Query(...),
):
    parsed_start = DateParse.parse_date_dmy(start_date)
    parsed_end = DateParse.parse_date_dmy(end_date)
    facade = TravelFacade()
    return facade.search_all(parsed_start, parsed_end, origin, destination)
