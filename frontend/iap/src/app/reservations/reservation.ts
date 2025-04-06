export default interface Reservation {
    id: number;

	carId: {
        id: number;
        name: string;
        picture: string;
        pricePerDay: number;
    };

	// RentUser userId;

	startDate: string;

	endDate: string;
}

