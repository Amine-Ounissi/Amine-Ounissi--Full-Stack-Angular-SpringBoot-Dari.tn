
import { Component, OnInit } from '@angular/core';
import { ReserveService } from '../services/reserve.service';
import { Reserve } from '../reserve/reserve';
import { ActivatedRoute, Router } from '@angular/router';
@Component({
  selector: 'app-update-reserve',
  templateUrl: './update-reserve.component.html',
  styleUrls: ['./update-reserve.component.css']
})
export class UpdateReserveComponent implements OnInit {

  id!: number;
  Reserve: Reserve = new Reserve();
  constructor(
    private ReserveService: ReserveService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.Reserve = new Reserve();
    this.id = this.route.snapshot.params['id'];

    this.ReserveService.getReserveById(this.id).subscribe(
      (data) => {
        this.Reserve = data;
      },
      (error) => console.log(error)
    );
  }
  updateReserve() {
    this.ReserveService
      .updateReserve(this.id, this.Reserve)
      .subscribe(
        (data) => {
          console.log(data);
          //this.Reserve = new Reserve();
          this.goToReserveList();
          //this.gotoList();
        },
        (error) => console.log(error)
      );
  }
  onSubmit() {
    this.updateReserve();
  }
  goToReserveList() {
    this.router.navigate(['listereservation/', this.id]);
  }
}
