export type IRole = "ROLE_USER" | "ROLE_ADMIN"

export default interface User {
    id: number;
	login: string;
	name: string;
	surname: string;
	role: IRole;
}