import {AfterViewInit, Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-domain-chart',
  templateUrl: './domain-chart.component.html',
  styleUrls: ['./domain-chart.component.css']
})
export class DomainChartComponent implements OnInit, AfterViewInit {

  //private date_m = ['10-01', '10-02', '10-03', '10-04', '10-05', '10-06', '10-07','10-01', '10-02', '10-03', '10-04', '10-05', '10-06', '10-07','10-01', '10-02', '10-03', '10-04', '10-05', '10-06', '10-07','10-01', '10-02', '10-03', '10-04', '10-05', '10-06', '10-31'];
  //private duData_m = [2017, 1890, 2386, 1927, 2403, 2301, 2685,2017, 1890, 2386, 1927, 2403, 2301, 2685,2017, 1890, 2386, 1927, 2403, 2301, 2685,2017, 1890, 2386, 1927, 2403, 2301, 2685];
  //private seData_m = [1312, 1069, 1200, 1479, 1021, 1537, 1094,1312, 1069, 1200, 1479, 1021, 1537, 1094,1312, 1069, 1200, 1479, 1021, 1537, 1094,1312, 1069, 1200, 1479, 1021, 1537, 1094];
  //private sumData_m = [3300, 2900, 3500, 3400, 3400, 3800, 3700,3300, 2900, 3500, 3300, 3400, 3800, 3700,3300, 2900, 3500, 3300, 3400, 3800, 3700,3300, 2900, 3500, 3300, 3400, 3800, 3600];

  private date_m = [];
  private duData_m = [];
  private seData_m = [];
  private sumData_m = [];

  ngAfterViewInit():void{
    this.eChartsOption(this.date_m, this.seData_m, this.duData_m, this.sumData_m);
  }

  constructor(private http: HttpClient) {
  }

  ngOnInit() {
    this.getData();
  }

  getData() {
    let url = "http://localhost:8080/getEChartsDataMonth";
    this.http.post(url, {})
      .toPromise().then((data: any) => {
      if (data != null) {
        this.date_m = data.dateList;
        this.seData_m = data.seCountList;
        this.duData_m = data.duCountList;
        this.sumData_m = data.sumCountList;
        console.log(data);
        this.eChartsOption(this.date_m, this.seData_m, this.duData_m, this.sumData_m);
      }
    });
  }

  eChartsOption(date: any[], seData:any[], duData:any[], sumData: any[]) {
    let line = echarts.init(document.getElementById("domain-chart"));
    let option = {
      title: {
        text: "近一个月每日域名数量",
        x: 'center',
        textStyle: {
          color: '#D2A968', //353C48
          fontSize: 14,
          fontWeight: 'normal'
        },
        y: 'top',
        top:20
      },
      tooltip: {},
      xAxis: [{
        /*nameTextStyle: {
          color: "#E4ECF5"
        },*/
        axisLine: {
          lineStyle: {
            color: "#D2A968"
          }
        },
        type: 'category',
        data: date,
        axisTick: {alignWithLabel: true}
      },

      ],
      yAxis: [{
        splitLine: {
          lineStyle: {
            color: "#353C48"
          }
        },
        type: 'value',
        axisLine: {
          lineStyle: {
            color: "#D2A968"
          }
        }
      }],
      series: [
        {
          name: '色情域名',
          type: 'bar',
          radius: '30%',
          data: seData,
          itemStyle: {
            normal: {
              opacity: 1,
              color: "#6FB4CE"
            },
            emphasis: {
              shadowBlur: 0,
              shadowOffsetX: 0
            }
          }
        },
        {
          name: '赌博域名',
          type: 'bar',
          radius: '30%',
          data: duData,
          itemStyle: {
            normal: {
              opacity: 1,
              color: "#A9BD7A"
            },
            emphasis: {
              shadowBlur: 0,
              shadowOffsetX: 0
            }
          }
        },{
          name: '域名总量',
          type: 'line',
          radius: '30%',
          data: sumData,
          itemStyle: {
            normal: {
              opacity: 1,
              color: "#FFBE0A"
            },
            emphasis: {
              shadowBlur: 0,
              shadowOffsetX: 0
            }
          }
        }
      ]
    };
    line.setOption(option);
  }

}
