$(function(){
    option = {
        series: [
            {
                // name: '服务项目',
                type: 'gauge',
                radius: '83%', //图表尺寸
                center: ['50%', '45%'],
                startAngle: 215,
                endAngle: -35,
                axisLine: {
                    show: true,
                    lineStyle: {
                        color: [
                            // [dataArr / 100, colorSet.color],
                            [1, "#00FF2A"]
                        ],
                        // color: '#00FF2A',
                        width: 0
                    }
                },
                axisTick: {
                    show: true,
                    lineStyle: {
                        color: 'auto',
                        width: 2
                    },
                    length: -3,
                    splitNumber: 5
                },
                splitLine: {
                    show: true,
                    length: -3,
                    lineStyle: {
                        color: 'auto',
                        width: 2
                    }
                },
                axisLabel: {
                    show: false
                },
                pointer: { //仪表盘指针
                    show: false,
                },
                detail: {
                    show: false,
                },
                title: {
                    show: true,
                    offsetCenter: [0, '80%'], // x, y，单位px
                    textStyle: {
                        offsetCenter:[0,'50%'],
                        formatter: '服务项目',
                        color: '#fff',
                        fontSize: 14,
                        backgroundColor: "#062961",
                        borderRadius: 25,
                        padding: [8,12,6,12],
                        shadowColor: '#00FF2A',
                        shadowBlur: 10,
                        borderColor: '#00FF2A',
                        borderWidth:2,
                        zlevel: 100,
                        shadowOffsetX: 0
                    }
                },
                data: [{
                    name: "服务项目",
                    value: 11
                }]
            },
            {
                type: 'gauge',
                radius: '78%',
                center: ['50%', '45%'],
                splitNumber: 0, //刻度数量
                startAngle: 225,
                endAngle: -45,
                axisLine: {
                    show: true,
                    lineStyle: {
                        color: [
                            [1, "#00FF2A"]
                        ],
                        width: 12
                    }
                },
                 //分隔线样式。
                splitLine: {
                    show: false,
                },
                axisLabel: {
                    show: false
                },
                axisTick: {
                    show: false
                },
                pointer: {
                    show: false
                },
                title: {
                    show: false,
                },
                 //仪表盘详情，用于显示数据。
                detail: {
                    show: true,
                    offsetCenter: ['-2%', '5%'],
                    color: '#fff',
                    fontSize: 16,
                    fontWeight: 600,
                    // fontFamily: ,
                    textShadowColor: '#00FF2A',
                    textShadowBlur: 6,
                    formatter: function(params) {
                        return params
                    },
                    textStyle: {
                        fontSize: 32
                    }
                },
                data: [{
                    name: "数量",
                    value: 189
                }]
                }
        ]
    };
    option1 = {
        series: [
            {
                // name: '服务项目',
                type: 'gauge',
                radius: '83%', //图表尺寸
                center: ['50%', '45%'],
                startAngle: 215,
                endAngle: -35,
                axisLine: {
                    show: true,
                    lineStyle: {
                        color: [
                            // [dataArr / 100, colorSet.color],
                            [1, "#00FFFC"]
                        ],
                        // color: '#00FFFC',
                        width: 0
                    }
                },
                axisTick: {
                    show: true,
                    lineStyle: {
                        color: 'auto',
                        width: 2
                    },
                    length: -3,
                    splitNumber: 5
                },
                splitLine: {
                    show: true,
                    length: -3,
                    lineStyle: {
                        color: 'auto',
                        width: 2
                    }
                },
                axisLabel: {
                    show: false
                },
                pointer: { //仪表盘指针
                    show: false,
                },
                detail: {
                    show: false,
                },
                title: {
                    show: true,
                    offsetCenter: [0, '80%'], // x, y，单位px
                    textStyle: {
                        offsetCenter:[0,'50%'],
                        formatter: '服务对接',
                        color: '#fff',
                        fontSize: 14,
                        backgroundColor: "#062961",
                        borderRadius: 25,
                        padding: [8,12,6,12],
                        shadowColor: '#00FFFC',
                        shadowBlur: 10,
                        borderColor: '#00FFFC',
                        borderWidth:2,
                        zlevel: 100,
                        shadowOffsetX: 0
                    }
                },
                data: [{
                    name: "服务对接",
                    value: 11
                }]
            },
            {
                type: 'gauge',
                radius: '78%',
                center: ['50%', '45%'],
                splitNumber: 0, //刻度数量
                startAngle: 225,
                endAngle: -45,
                axisLine: {
                    show: true,
                    lineStyle: {
                        color: [
                            [1, "#00FFFC"]
                        ],
                        width: 12
                    }
                },
                 //分隔线样式。
                splitLine: {
                    show: false,
                },
                axisLabel: {
                    show: false
                },
                axisTick: {
                    show: false
                },
                pointer: {
                    show: false
                },
                title: {
                    show: false,
                },
                 //仪表盘详情，用于显示数据。
                detail: {
                    show: true,
                    offsetCenter: ['-2%', '5%'],
                    color: '#fff',
                    fontSize: 16,
                    fontWeight: 600,
                    // fontFamily: ,
                    textShadowColor: '#00FFFC',
                    textShadowBlur: 6,
                    formatter: function(params) {
                        return params
                    },
                    textStyle: {
                        fontSize: 32
                    }
                },
                data: [{
                    name: "数量",
                    value: 189
                }]
                }
        ]
    };
    var mychart3 = echarts.init(document.getElementById("S127_echart3"));
    var mychart4 = echarts.init(document.getElementById("S127_echart4"));
    mychart3.setOption(option);
    window.addEventListener("resize", function() {
        mychart3.resize();
    });
    mychart4.setOption(option1);
    window.addEventListener("resize", function() {
        mychart4.resize();
    });
})