import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateEmployeeComponent } from './create-employee/create-employee.component';
import { EmployeeDetailsComponent } from './employee-details/employee-details.component';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import { GetEmployeeByIdComponent } from './get-employee-by-id/get-employee-by-id.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { UpdateEmployeeComponent } from './update-employee/update-employee.component';

const routes: Routes = [
  { path: 'employees', component: EmployeeListComponent },
  { path: "create-employee", component: CreateEmployeeComponent },
  { path: "login", component: LoginComponent },
  { path: "", component: LoginComponent },
  { path: "logout", component: LogoutComponent },
  /*{ path: '', redirectTo: 'employees', pathMatch: 'full' },*/
  { path: 'update-employee/:id', component: UpdateEmployeeComponent },
  { path: 'employee-details/:id', component: EmployeeDetailsComponent },
  { path: 'get-employee-by-id', component: GetEmployeeByIdComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
