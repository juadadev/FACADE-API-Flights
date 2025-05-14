from fastapi import FastAPI
from fastapi.middleware.cors import CORSMiddleware

from app.routes.search_flights import route_search_flights

app = FastAPI()

app.include_router(route_search_flights)

app.add_middleware(
    CORSMiddleware,
    allow_origins=['*'],
    allow_credentials=True,
    allow_methods=['*'],
    allow_headers=['*'],
)
