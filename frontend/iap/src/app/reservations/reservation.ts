export default interface Reservation {
    id: number;

	carId: {
        id: number;
        name: string;
        picture: string;
        procePerDay: number;
    };

	// RentUser userId;

	startDate: string;

	endDate: string;
}

