import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
interface ItemData {
  name: string;
  age: number;
  address: string;
}

@Component({
  selector: 'app-rapid-table',
  templateUrl: './rapid-table.component.html',
  styleUrls: ['./rapid-table.component.css']
})
export class RapidTableComponent implements OnInit {

  private dateRage: any;
  private pageIndex: number;
  private pageSize: number = 10;
  private total: number = 200;
  private startTime: string = "";
  private endTime: string = "";
  private fileType: string = null;
  private status: string = null;
  private sortName: string = "";
  private sortValue: string = "";
  private list: any = [{}];

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.search();
  }

  search() {
    this.pageIndex = 1;
    this.getData();
  }

  indexChange() {
    this.getData();
  }

  sort(data: any) {
    this.sortName = data.key;
    this.sortValue = data.value;
    this.getData();
  }

  getData() {
    let url = "http://localhost:8080/getRapid7Data";
    this.http.post(url, {"pageIndex": this.pageIndex, "pageSize": this.pageSize, "startTime": this.startTime,
      "endTime": this.endTime, "fileType": this.fileType, "status": this.status, "sortName": this.sortName,
      "sortValue": this.sortValue})
      .toPromise().then((data: any) => {
        if (data != null) {
          this.list = data.rapid7Data;
          this.total = data.total;
        }
    });
  }

  setTime() {
    this.startTime = this.dateRage[0];
    this.endTime = this.dateRage[1];
  }

}
