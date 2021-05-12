import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-get-employee-by-id',
  templateUrl: './get-employee-by-id.component.html',
  styleUrls: ['./get-employee-by-id.component.css']
})
export class GetEmployeeByIdComponent implements OnInit {

  id: number;
  employee: Employee;
  constructor(private route: ActivatedRoute, private router: Router, private employeeService: EmployeeService) { }

  ngOnInit(): void {
    //this.id = this.route.snapshot.params['id'];

    //this.employee = new Employee();
    this.employeeService.getEmployeeById(this.id).subscribe(data => {
      this.employee = data;
    });

  }
  employeeDetails(id: number) {
    this.router.navigate(['employee-details', id]);
  }
}
