$(function(){
    let color = [
        "#1C81EF",
        "#C63CFF",
        '#102259'
    ];
    let echartData = [{
            name: "1",
            value1: 30,
            value2: 39
        },
        {
            name: "2",
            value1: 38,
            value2: 50
        },
        {
            name: "3",
            value1: 43,
            value2: 82
        },
        {
            name: "4",
            value1: 32,
            value2: 61
        },
        {
            name: "5",
            value1: 20,
            value2: 36
        },
        {
            name: "6",
            value1: 36,
            value2: 38
        },
        {
            name: "7",
            value1: 40,
            value2: 64
        },
        {
            name: "8",
            value1: 19,
            value2: 38
        },
        {
            name: "9",
            value1: 20,
            value2: 35
        },
        {
            name: "10",
            value1: 38,
            value2: 62
        },
        {
            name: "11",
            value1: 23,
            value2: 40
        },
        {
            name: "12",
            value1: 17,
            value2: 41
        }
    ];
    
    let xAxisData = echartData.map(v => v.name);
    //  ["1", "2", "3", "4", "5", "6", "7", "8"]
    let yAxisData1 = echartData.map(v => v.value1);
    // [100, 138, 350, 173, 180, 150, 180, 230]
    let yAxisData2 = echartData.map(v => v.value2);
    // [233, 233, 200, 180, 199, 233, 210, 180]
    const hexToRgba = (hex, opacity) => {
        let rgbaColor = "";
        let reg = /^#[\da-f]{6}$/i;
        if (reg.test(hex)) {
            rgbaColor = `rgba(${parseInt("0x" + hex.slice(1, 3))},${parseInt(
            "0x" + hex.slice(3, 5)
        )},${parseInt("0x" + hex.slice(5, 7))},${opacity})`;
        }
        return rgbaColor;
    }
    
    option = {
        // backgroundColor: color,
        color: color,
        legend: {
            center: 0,
            top: 10,
            textStyle: {
                color: "rgba(250,250,250,0.6)",
                fontSize: 16,
            }
        },
        tooltip: {
            trigger: "axis",
            formatter: function(params) {
                let html = '';
                params.forEach(v => {
                    html += `<div style="color: #666;font-size: 14px;line-height: 24px">
                    <span style="display:inline-block;margin-right:5px;border-radius:10px;width:10px;height:10px;background-color:${color[v.componentIndex]};"></span>
                    ${v.seriesName}.${v.name}
                    <span style="color:${color[v.componentIndex]};font-weight:700;font-size: 18px">${v.value}</span>
                    `;
                })
                return html
            },
            extraCssText: 'border-radius: 0;box-shadow: 0 0 3px rgba(0, 0, 0, 0.2);color: #333;',
            axisPointer: {
                type: 'line',
                lineStyle: {
                    color: '#0D73D8',
                    // shadowColor: 'rgba(10,38,97,0.2)',
                    // shadowBlur: 5
                }
            }
        },
        grid: {
            top: 55,
            left: 20,
            right: 35,
            bottom: 15,
            containLabel: true
        },
        xAxis: [{
            type: "category",
            boundaryGap: false,
            axisLabel: {
                formatter: '{value}月',
                interval: 0,
                textStyle: {
                    color: "#1598ed"
                }
            },
            axisLine: {
                lineStyle: {
                    color: "#224885"
                }
            },
            data: xAxisData
        }],
        yAxis: [{
            type: "value",
            axisLabel: {
                textStyle: {
                    color: "#1598ed"
                }
            },
            splitLine: {
                lineStyle: {
                    color: "#224885"
                }
            },
            axisLine: {
                show: true,
                lineStyle: {
                    color: "#224885"
                }
            },
            axisTick: {
                show: false
            }
        }],
        series: [{
            name: "服务对接",
            type: "line",
            smooth: true,
            // showSymbol: false,/
            symbolSize: 0,
            zlevel: 3,
            lineStyle: {
                normal: {
                    color: color[0],
                    shadowBlur: 3,
                    shadowColor: hexToRgba(color[0], 0.5),
                    shadowOffsetY: 5
                }
            },
            areaStyle: {
                normal: {
                    color: new echarts.graphic.LinearGradient(
                        0,
                        0,
                        0,
                        1,
                        [{
                                offset: 0,
                                color: hexToRgba(color[0], 0.3)
                            },
                            {
                                offset: 1,
                                color: hexToRgba(color[2], 0.1)
                            }
                        ],
                        false
                    ),
                    shadowColor: hexToRgba(color[0], 0.1),
                    shadowBlur: 10
                }
            },
            data: yAxisData1
        }, {
            name: "服务项目",
            type: "line",
            smooth: true,
            // showSymbol: false,
            symbolSize: 0,
            zlevel: 3,
            lineStyle: {
                normal: {
                    color: color[1],
                    shadowBlur: 3,
                    shadowColor: hexToRgba(color[1], 0.5),
                    shadowOffsetY: 5
                }
            },
            areaStyle: {
                normal: {
                    color: new echarts.graphic.LinearGradient(
                        0,
                        0,
                        0,
                        1,
                        [{
                                offset: 0,
                                color: hexToRgba(color[1], 0.3)
                            },
                            {
                                offset: 1,
                                color: hexToRgba(color[2], 0.1)
                            }
                        ],
                        false
                    ),
                    shadowColor: hexToRgba(color[1], 0.1),
                    shadowBlur: 10
                }
            },
            data: yAxisData2
        }]
    };
    var mychart2 = echarts.init(document.getElementById("S127_echart2"));
    mychart2.setOption(option);
    window.addEventListener("resize", function() {
        mychart2.resize();
    });
})