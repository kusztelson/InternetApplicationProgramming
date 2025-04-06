export default interface Reservation {
    id: number;

	carId: {
        id: number;
        name: string;
        picture: string;
        pricePerDay: number;
        category: string;
    };


	// RentUser userId;

	startDate: string;

	endDate: string;
}

