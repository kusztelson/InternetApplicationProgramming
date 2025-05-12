import { inject } from '@angular/core';
import { CanActivateFn } from '@angular/router';
import { LoginService } from '../login/login.service';

export const adminGuard: CanActivateFn = (route, state) => {
  let isAdmin = inject(LoginService).getUserRole() == 'ROLE_ADMIN'
  if(!isAdmin) alert("You must be logged in as Admin to access this feature")
  return isAdmin;
};
