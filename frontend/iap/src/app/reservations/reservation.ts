import { Car } from "../cars/car.model";
import { RentUser } from "../reservation/rentUser.model";

export default interface Reservation {
    id: number;

	carId: Car;

	userId: RentUser;

	startDate: string;

	endDate: string;
}

