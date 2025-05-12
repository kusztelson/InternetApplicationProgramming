import { inject } from '@angular/core';
import { CanActivateFn } from '@angular/router';
import { LoginService } from '../login/login.service';

export const userGuard: CanActivateFn = (route, state) => {
  let isUser = inject(LoginService).getUserRole() == 'ROLE_USER'
  if(!isUser) alert("You must be logged in as User to access this feature")
  return isUser;
};
