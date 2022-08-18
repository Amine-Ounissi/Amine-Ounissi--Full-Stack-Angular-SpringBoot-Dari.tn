import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ReserveService } from '../services/reserve.service';
import { Reserve } from '../reserve/reserve';
import { Announcement } from '../announcement';


@Component({
  selector: 'app-reservedetails',
  templateUrl: './reservedetails.component.html',
  styleUrls: ['./reservedetails.component.css']
})

export class ReservedetailsComponent implements OnInit {
  id!: number;
  reserve!: Reserve;
  //announcement!: Announcement;
  constructor(private router:Router,
    private route: ActivatedRoute,
    private ReserveService: ReserveService
  ) {}

toPayement()
{
  this.router.navigate(['payment'])
}
toViewannonce()
{
  this.router.navigate(['announcements'])
}

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.reserve = new Reserve();
    this.ReserveService.getReserveById(this.id).subscribe((data) => {
      this.reserve = data;
    });
  }
  
}
