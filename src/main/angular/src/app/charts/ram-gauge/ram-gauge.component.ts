import {AfterViewInit, Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-ram-gauge',
  templateUrl: './ram-gauge.component.html',
  styleUrls: ['./ram-gauge.component.css']
})
export class RamGaugeComponent implements OnInit,AfterViewInit {

  ngAfterViewInit(): void {
    let option = {

      series: [
        {
          center: ['50%', '60%'],
          radius:'100%',
          title:{color: '#D2A968',},
          name: '内存使用率',
          type: 'gauge',
          endAngle:-5,
          startAngle:185,
          /*仪表盘设置*/
          axisLine:{lineStyle:{color:[[0.2, '#A9BD7A'], [0.8, '#6FB4CE'], [1, '#BF7A6A']],width:8}},
          /* 仪表盘分割线 长线*/
          splitLine:{length:6,lineStyle: {width:1},show:false},
          /* 仪表盘分割线 短线 */
          axisTick:{length:3},
          axisLabel:{fontSize :12},
          detail: {formatter: '{value}%'},
          data: [{value: 50, name: '内存使用率'}],
          /* 指针设置 */
          pointer:{width:4}
        }
      ]
    };
    let gauge = echarts.init(document.getElementById("ram_gauge"));
    gauge.setOption(option);
    setInterval(function () {
      option.series[0].data[0].value = parseInt((Math.random() * 100).toFixed(2));
      gauge.setOption(option, true);
    },2000);
  }

  constructor() {
  }

  ngOnInit() {
  }

}
