from fastapi import FastAPI

from app.routes.search_flights import route_search_flights

app = FastAPI()

app.include_router(route_search_flights)
