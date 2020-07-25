$(document).ready(function() {


    var yearData2 =[];
    var countData2 = [];
    $.ajax({
        cache: true,
        contentType: "application/json",
        dataType: "json",
        type: "POST",
        url: "/index/park/income",
        async: false,
        error: function (request) {
            $.modal.alertError("系统错误");
        },
        success: function (data) {
            for(var i = 0; i < data.length; i++) {
                yearData2.push(data[i].year)
                countData2.push(data[i].income)
            }

        }
    });
    window.addEventListener('resize', function() {
        mychart1.resize()
        mychart2.resize()
    })

    // 循环粒子100个dom
    var htmlDom = '<div class="circle-container"><div class="circle"></div></div>';
    for (var i = 0; i < 100; i++) {
        $('.R126_cr_particle .container').append(htmlDom);
    }

    var colorArr1 = [
        {
            top: '#FE9D19',
            bottom: '#D04597'
        },
        {
            top: '#72F5C8',
            bottom: '#10C06D'
        },
        {
            top: '#FFD633',
            bottom: '#FF9B08'
        },
        {
            top: '#4BE4FC',
            bottom: '#2B65FF'
        }
    ]
    var option1 = {
        grid: {
            left: '2%',
            right: '2%',
            bottom: '0%',
            top: '8%',
            containLabel: true
        },
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'none'
            },
        },
        xAxis: {
            type: 'value',
            splitLine: {
                show: true,
                lineStyle: {
                    color: '#0E2B5F'
                }
            },
            axisTick: {
                show: false
            },
            axisLine: {
                show: false
            },
            axisLabel: {
                show: false
            },
        },
        yAxis: [{
            type: 'category',
            inverse: true,
            axisLabel: {
                show: true,
                textStyle: {
                    color: '#88C7E9',
                    fontSize: 16
                },
            },
            splitLine: {
                show: false
            },
            axisTick: {
                show: false
            },
            axisLine: {
                show: true,
                lineStyle:{
                    color:'#0B408D'
                }
            },
            data: yearData2
        }, {
            type: 'category',
            inverse: true,
            axisTick: 'none',
            axisLine: 'none',
            show: true,
            splitLine: {
                show: false
            },
            axisLine: {
                show: false
            },
            axisLabel: {
                textStyle: {
                    color: '#C68F34',
                    fontSize: '16',
                    fontWeight: 'bold'
                },
                formatter: function(params){
                    return params + '万'
                },
            },
            data:countData2
        }],
        series: [
            {
                name: '园区收入',
                type: 'bar',
                label:{
                    show:false
                },
                itemStyle: {
                    normal: {
                        barBorderRadius: [0,30,30,0],
                        color: function(params) {
                            // let num = colorArr1.length;
                            if(params.dataIndex < 3){
                                return new echarts.graphic.LinearGradient(0, 0, 1, 0,[{
                                    offset: 0,
                                    color: colorArr1[params.dataIndex].top // 0% 处的颜色
                                },{//可根据具体情况决定哪根柱子显示哪种颜色
                                    offset: 1,
                                    color: colorArr1[params.dataIndex].bottom // 100% 处的颜色
                                }],false);
                            }else {
                                return new echarts.graphic.LinearGradient(0, 0, 1, 0,[{
                                    offset: 0,
                                    color: colorArr1[3].top // 0% 处的颜色
                                },{//可根据具体情况决定哪根柱子显示哪种颜色
                                    offset: 1,
                                    color: colorArr1[3].bottom // 100% 处的颜色
                                }],false);
                            }
                        },
                    },
                },
                barWidth: 15,
                data: [500, 220, 100, 500, 200, 150]
            }

        ]
    }
    // var mychart1 = echarts.init(document.getElementById('D126_incomeChart'))
    // mychart1.setOption(option1)


    var yearData1 =[];
    var countData1 = [];
    $.ajax({
        cache: true,
        contentType: "application/json",
        dataType: "json",
        type: "POST",
        url: "/index/left/trend",
        async: false,
        error: function (request) {
            $.modal.alertError("系统错误");
        },
        success: function (data) {
            for(var i = 0; i < data.length; i++) {
                yearData1.push(data[i].year)
                countData1.push(data[i].count)
            }

        }
    });
    var option2 = {
        grid: {
            left: '5%',
            top: '5%',
            bottom: '15%',
            right: '8%'
        },
        xAxis: {
            data: yearData1,
            axisTick: {
                show: false
            },
            axisLine: {
                lineStyle: {
                    color: '#065279',
                    width: 1 //这里是为了突出显示加上的
                }
            },
            axisLabel: {
                textStyle: {
                    color: '#5E9BD4',
                    fontSize: 16
                }
            }
        },
        yAxis: [{
            splitNumber: 2,
            axisTick: {
                show: false
            },
            axisLine: {
                lineStyle: {
                    color: '#065279',
                    width: 1 //这里是为了突出显示加上的
                }
            },
            axisLabel: {
                textStyle: {
                    color: '#5E9BD4',
                    fontSize: 16
                }
            },
            splitArea: {
                areaStyle: {
                    color: 'rgba(255,255,255,.5)'
                }
            },
            splitLine: {
                show: true,
                lineStyle: {
                    color: '#122F59',
                    width: 0.5
                }
            }
        }
        ],
        series: [{
            name: '入园企业趋势',
            type: 'pictorialBar',
            barCategoryGap: '30%',
            symbol: 'path://M150 50 L130 130 L170 130  Z',
            label: {
                show: false
            },
            itemStyle: {
                normal: {
                    color: {
                        type: 'linear',
                        x: 0,
                        y: 0,
                        x2: 0,
                        y2: 1,
                        colorStops: [{
                            offset: 0,
                            color: 'rgba(8,244,254, .8)' //  0%  处的颜色
                        },
                            {
                                offset: 1,
                                color: 'rgba(8,244,254, .1)' //  100%  处的颜色
                            }
                        ],
                        global: false //  缺省为  false
                    }
                },
                emphasis: {
                    opacity: 1
                }
            },
            data: countData1,

            z: 10
        }]
    }
    var mychart2 = echarts.init(document.getElementById('D126_trendChart'))
    mychart2.setOption(option2)

})
