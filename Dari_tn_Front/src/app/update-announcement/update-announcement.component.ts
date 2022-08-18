import { Component, OnInit } from '@angular/core';
import { AnnouncementService } from '../announcement.service';
import { Announcement } from '../announcement';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-announcement',
  templateUrl: './update-announcement.component.html',
  styleUrls: ['./update-announcement.component.css'],
})
export class UpdateAnnouncementComponent implements OnInit {
  id!: number;
  announcement: Announcement = new Announcement();
  constructor(
    private annoucementService: AnnouncementService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.announcement = new Announcement();
    this.id = this.route.snapshot.params['id'];

    this.annoucementService.getAnnouncementById(this.id).subscribe(
      (data) => {
        this.announcement = data;
      },
      (error) => console.log(error)
    );
  }
  updateAnnouncement() {
    this.annoucementService
      .updateAnnouncement(this.id, this.announcement)
      .subscribe(
        (data) => {
          console.log(data);
          this.announcement = new Announcement();
          this.goToAnnouncementList();
          //this.gotoList();
        },
        (error) => console.log(error)
      );
  }
  onSubmit() {
    this.updateAnnouncement();
  }
  goToAnnouncementList() {
    this.router.navigate(['/announcements']);
  }
}
