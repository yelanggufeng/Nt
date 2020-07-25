$(function(){
    var data0 = []
    var data1 = []

    $.ajax({
        cache: true,
        contentType: "application/json",
        dataType: "json",
        type: "GET",
        url: "/statistics/dimension/income/tax/1",
        async: false,
        error: function (request) {
            $.modal.alertError("系统错误");
        },
        success: function (data) {
            for(var i = 0; i < data.length; i++) {
                data0.push(data[i].year)
                data1.push(data[i].income)
            }
        }
    });
    var option3 = {
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                lineStyle: {
                    color: {
                        type: 'linear',
                        x: 0,
                        y: 0,
                        x2: 0,
                        y2: 1,
                        colorStops: [{
                            offset: 0,
                            color: 'rgba(0, 255, 233,0)'
                        }, {
                            offset: 0.5,
                            color: 'rgba(255, 255, 255,1)',
                        }, {
                            offset: 1,
                            color: 'rgba(0, 255, 233,0)'
                        }],
                        global: false
                    }
                },
            },
        },
        grid: {
            top: '5%',
            left: '0%',
            right: '5%',
            bottom: '5%',
            containLabel: true
        },
        xAxis: [{
            type: 'category',
            axisLine: {
                show: true,
                lineStyle: {
                    color: '#224885'
                },
            },
            splitArea: {
                // show: true,
                color: '#f00',
                lineStyle: {
                    color: '#f00'
                },
            },
            axisLabel: {
                color: '#009cff',
                fontSize: 14,
                align: 'right',
                interval: 0
            },
            splitLine: {
                show: false
            },
            axisTick: {
                show: false,
            },
            boundaryGap: false,
            data: data0,
        }],
        yAxis: [{
            type: 'value',
            min: 0,
            // max: 100,
            // max: 140,
            // splitNumber: 5,
            splitLine: {
                show: true,
                lineStyle: {
                    color: '#224885'
                }
            },
            axisLine: {
                show: true,
                lineStyle: {
                    color: '#224885'
                },
            },
            axisLabel: {
                show: true,
                margin: 20,
                textStyle: {
                    color: '#009cff',
                    fontSize: 14
                },
            },
            axisTick: {
                show: false,
            },
        }],
        series: [{
                type: 'line',
                smooth: true, //是否平滑
                showAllSymbol: true,
                symbolSize: 0,
                lineStyle: {
                    normal: {
                        color: "#a237e0",
                        width: 3,
                        shadowColor: 'rgba(162, 55, 224, .3)',
                        shadowBlur: 0,
                        shadowOffsetY: 1,
                        shadowOffsetX: 1,
                    },
                },
                label: {
                    show: false,
                },
                itemStyle: {
                    color: "#6c50f3",
                    borderColor: "#fff",
                    borderWidth: 3,
                    shadowColor: 'rgba(0, 0, 0, .3)',
                    shadowBlur: 0,
                    shadowOffsetY: 2,
                    shadowOffsetX: 2,
                },
                tooltip: {
                    show: true,
                    trigger: 'axis'
                },
                areaStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                                offset: 0,
                                color: 'rgba(72,46,146,0.6)'
                            },
                            {
                                offset: 1,
                                color: 'rgba(11,34,89,0)'
                            }
                        ], false),
                        shadowColor: 'rgba(108,80,243, 0.9)',
                        shadowBlur: 20
                    }
                },
                data: data1
            },
        ]
    };
    var mychart3 = echarts.init(document.getElementById("J127_echart3"));
    mychart3.setOption(option3);
    window.addEventListener("resize", function() {
        mychart3.resize();
    });

    var data2 = []
    var data3 = []

    $.ajax({
        cache: true,
        contentType: "application/json",
        dataType: "json",
        type: "GET",
        url: "/statistics/dimension/income/tax/2",
        async: false,
        error: function (request) {
            $.modal.alertError("系统错误");
        },
        success: function (data) {
            for(var i = 0; i < data.length; i++) {
                data2.push(data[i].year)
                data3.push(data[i].tax)
            }
        }
    });
    var option4 = {
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                lineStyle: {
                    color: {
                        type: 'linear',
                        x: 0,
                        y: 0,
                        x2: 0,
                        y2: 1,
                        colorStops: [{
                            offset: 0,
                            color: 'rgba(0, 255, 233,0)'
                        }, {
                            offset: 0.5,
                            color: 'rgba(255, 255, 255,1)',
                        }, {
                            offset: 1,
                            color: 'rgba(0, 255, 233,0)'
                        }],
                        global: false
                    }
                },
            },
        },
        grid: {
            top: '5%',
            left: '0%',
            right: '5%',
            bottom: '5%',
            containLabel: true
        },
        xAxis: [{
            type: 'category',
            axisLine: {
                show: true,
                lineStyle: {
                    color: '#224885'
                },
            },
            splitArea: {
                // show: true,
                color: '#f00',
                lineStyle: {
                    color: '#f00'
                },
            },
            axisLabel: {
                color: '#009cff',
                fontSize: 14,
                align: 'right',
                interval: 0
            },
            splitLine: {
                show: false
            },
            axisTick: {
                show: false,
            },
            boundaryGap: false,
            data: data2,
        }],
        yAxis: [{
            type: 'value',
            min: 0,
            // max: 100,
            // max: 140,
            // splitNumber: 5,
            splitLine: {
                show: true,
                lineStyle: {
                    color: '#224885'
                }
            },
            axisLine: {
                show: true,
                lineStyle: {
                    color: '#224885'
                },
            },
            axisLabel: {
                show: true,
                margin: 20,
                textStyle: {
                    color: '#009cff',
                    fontSize: 14
                },
            },
            axisTick: {
                show: false,
            },
        }],
        series: [{
                type: 'line',
                smooth: false, //是否平滑
                showAllSymbol: true,
                symbol: 'circle',
                symbolSize: 12,
                lineStyle: {
                    normal: {
                        color: "#44f0ff",
                        width: 3,
                        shadowColor: 'rgba(68, 240, 255, .3)',
                        shadowBlur: 0,
                        shadowOffsetY: 1,
                        shadowOffsetX: 1,
                    },
                },
                label: {
                    show: false,
                },
                itemStyle: {
                    color: "#44f0ff",
                    shadowColor: 'rgba(0, 0, 0, .3)',
                    shadowBlur: 0,
                    shadowOffsetY: 2,
                    shadowOffsetX: 2,
                },
                tooltip: {
                    show: true
                },
                areaStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                                offset: 0,
                                color: 'rgba(25,88,119,0.6)'
                            },
                            {
                                offset: 1,
                                color: 'rgba(11,34,89,0)'
                            }
                        ], false),
                        shadowColor: 'rgba(25,88,119,0.7)',
                        shadowBlur: 20
                    }
                },
                data: data3
            },
        ]
    };
    var mychart4 = echarts.init(document.getElementById("J127_echart4"));
    mychart4.setOption(option4);
    window.addEventListener("resize", function() {
        mychart4.resize();
    });


})
