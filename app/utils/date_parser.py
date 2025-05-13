from datetime import date, datetime

from fastapi import HTTPException


class DateParse:
    @staticmethod
    def parse_date_dmy(date_str: str) -> date:
        try:
            return datetime.strptime(date_str, '%d/%m/%Y').date()
        except ValueError as err:
            raise HTTPException(
                status_code=400,
                detail=(
                    f"Invalid date format for '{
                        date_str
                    }'Please show date in the format of the chose DD/MM/YYYY."
                ),
            ) from err
