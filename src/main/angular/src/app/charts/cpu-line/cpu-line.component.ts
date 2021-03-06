import {AfterViewInit, Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-cpu-line',
  templateUrl: './cpu-line.component.html',
  styleUrls: ['./cpu-line.component.css']
})
export class CpuLineComponent implements OnInit, AfterViewInit {


  ngAfterViewInit(): void {
    let datax = [];
    let datay = [];
    let line = echarts.init(document.getElementById("cpu-line"));
    let option = {
      title: {
        text: "CPU使用率走势图(%)",
        x: 'center',
        textStyle: {
          color: '#6FB4CE', //353C48
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
            color: "#6FB4CE"
          }
        },
        type: 'category',
        data: datax,
        axisTick: {alignWithLabel: true}
      },

      ],
      yAxis: [{
/*        name: "使用率",*/
  /*      nameTextStyle: {
          color: "#E4ECF5",
          fontFamily: "微软雅黑"
        },*/
        splitLine: {
          lineStyle: {
            color: "#353C48"
          }
        },
        type: 'value', min: 0, max: 100,
        axisLine: {
          lineStyle: {
            color: "#6FB4CE"
          }
        }
      }],
      series: [
        {
          name: 'CPU使用率',
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
        }]
    };
    line.setOption(option);
    setInterval(function () {
      let now = new Date();
      let value = parseInt((Math.random() * 100).toFixed(2));
      if (datax.length >= 20)
        datax.shift();
      if (datay.length >= 20)
        datay.shift();
      datax.push([now.getHours(), now.getMinutes(), now.getSeconds()].join(':'));
      datay.push(value);
      line.setOption({
        xAxis: {
          data: datax,
        },
        series: [{
          data: datay
        }]
      });
    }, 2000);
  }

  constructor() {
  }

  ngOnInit() {
  }


}
