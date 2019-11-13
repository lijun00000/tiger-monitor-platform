import {AfterViewInit, Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-flow-line',
  templateUrl: './flow-line.component.html',
  styleUrls: ['./flow-line.component.css']
})
export class FlowLineComponent implements OnInit, AfterViewInit {

  ngAfterViewInit():void{
    let datax = [];
    let datay = [];
    let datay2 = [];
    let line = echarts.init(document.getElementById("flow-line"));
    let option = {
      title: {
        text: "网络吞吐量速率(kb/s)",
        x: 'center',
        textStyle: {
          color: '#BF7A6A', //353C48
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
            color: "#BF7A6A"
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
        type: 'value', min: 0, max: 1000,
        axisLine: {
          lineStyle: {
            color: "#BF7A6A"
          }
        }
      }],
      series: [
        {
          name: '上传速率',
          type: 'line',
          radius: '30%',
          data: datay,
          itemStyle: {
            normal: {
              opacity: 1,
              color: "#6FB4CE"
            },
            emphasis: {
              shadowBlur: 0,
              shadowOffsetX: 0
            }
          }, areaStyle: {
            color: {
              type: 'linear',
              x: 1,
              y: 1,
              x2: 0,
              y2: 0,
              colorStops: [{
                offset: 0, color: '#E4ECF5' // 0% 处的颜色
              }, {
                offset: 1, color: '#6FB4CE' // 100% 处的颜色
              }],
            }
          }
        },
        {
          name: '下载速率',
          type: 'line',
          radius: '30%',
          data: datay2,
          itemStyle: {
            normal: {
              opacity: 1,
              color: "#A9BD7A"
            },
            emphasis: {
              shadowBlur: 0,
              shadowOffsetX: 0
            }
          }, areaStyle: {
            color: {
              type: 'linear',
              x: 1,
              y: 1,
              x2: 0,
              y2: 0,
              colorStops: [{
                offset: 0, color: '#EAF0EC' // 0% 处的颜色
              }, {
                offset: 1, color: '#A9BD7A' // 100% 处的颜色
              }],
            }
          }
        }
        ]
    };
    line.setOption(option);
    setInterval(function () {
      let now = new Date();
      let value = parseInt((Math.random() * 1000).toFixed(2));
      let value2 = parseInt((Math.random() * 1000).toFixed(2));
      if (datax.length >= 100)
        datax.shift();
      if (datay.length >= 100)
        datay.shift();
      if (datay2.length >= 100)
        datay2.shift();
      datax.push([now.getHours(), now.getMinutes(), now.getSeconds()].join(':'));
      datay.push(value);
      datay2.push(value2);
      line.setOption({
        xAxis: {
          data: datax,
        },
        series: [{
          data: datay
        },{
          data: datay2
        }]
      });
    }, 2000);
  }

  constructor() {
  }

  ngOnInit() {
  }


}
