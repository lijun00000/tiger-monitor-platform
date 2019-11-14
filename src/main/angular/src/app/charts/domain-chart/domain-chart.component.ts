import {AfterViewInit, Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-domain-chart',
  templateUrl: './domain-chart.component.html',
  styleUrls: ['./domain-chart.component.css']
})
export class DomainChartComponent implements OnInit, AfterViewInit {

  ngAfterViewInit():void{
    let datax = ['10-01', '10-02', '10-03', '10-04', '10-05', '10-06', '10-07','10-01', '10-02', '10-03', '10-04', '10-05', '10-06', '10-07','10-01', '10-02', '10-03', '10-04', '10-05', '10-06', '10-07','10-01', '10-02', '10-03', '10-04', '10-05', '10-06', '10-31'];
    let duData_m = [2017, 1890, 2386, 1927, 2403, 2301, 2685,2017, 1890, 2386, 1927, 2403, 2301, 2685,2017, 1890, 2386, 1927, 2403, 2301, 2685,2017, 1890, 2386, 1927, 2403, 2301, 2685];
    let seData_m = [1312, 1069, 1200, 1479, 1021, 1537, 1094,1312, 1069, 1200, 1479, 1021, 1537, 1094,1312, 1069, 1200, 1479, 1021, 1537, 1094,1312, 1069, 1200, 1479, 1021, 1537, 1094];
    let sumData_m = [3300, 2900, 3500, 3400, 3400, 3800, 3700,3300, 2900, 3500, 3300, 3400, 3800, 3700,3300, 2900, 3500, 3300, 3400, 3800, 3700,3300, 2900, 3500, 3300, 3400, 3800, 3600];
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
        data: datax,
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
          data: seData_m,
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
          data: duData_m,
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
          data: sumData_m,
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

  constructor() {
  }

  ngOnInit() {
  }


}
