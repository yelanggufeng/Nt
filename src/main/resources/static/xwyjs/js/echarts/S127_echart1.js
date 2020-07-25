$(function(){
    var option = {
        // backgroundColor: '#18163B',
        grid: {
            top: '18%',
            right: '3%',
            left: '8%',
            bottom: '15%'
        },
        xAxis: [{
            type: 'category',
            color: '#59588D',
            data: ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月'],
            // axisPointer: {
            //     type: 'line'
            // },
            axisTick: {
                show: false
            },
            axisLine: {
                lineStyle: {
                    color: '#0f3c67'
                }
            },
            axisLabel: {
                margin: 8,
                color: '#6ecbf9',
                interval: 0,
                textStyle: {
                    fontSize: 12
                },
            },
        }],
        yAxis: [{
            name: '单位：次',
            nameTextStyle: {
                color: '#6ecbf9',
                fontSize: 14
            },
            min: 0,
            max: 100,
            axisLabel: {
                color: '#6ecbf9',
                fontSize: 12
            },
            axisLine: {
                show: true,
                lineStyle: {
                    color: '#0f3c67'
                }
            },
            axisTick: {
                show: false
            },
            splitLine: {
                lineStyle: {
                    color: '#0f336c'
                }
            }
        }],
        series: [{
            type: 'bar',
            data: [79,62,52,58,82,62,83,58,62,23,37,38],
            barWidth: '14px',
            itemStyle: {
                normal: {
                    color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                        offset: 0,
                        color: 'rgba(1,178,254,1)' // 0% 处的颜色
                    }, {
                        offset: 1,
                        color: 'rgba(5,31,98,0.5)' // 100% 处的颜色
                    }], false),
                    // borderColor: '#02f6f4'
                } 
            },
            label: {
                normal: {
                    show: false
                }
            }
        }]
    };
    var mychart1 = echarts.init(document.getElementById("S127_echart1"));
    mychart1.setOption(option);
    window.addEventListener("resize", function() {
        mychart1.resize();
    });
})