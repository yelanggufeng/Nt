$(function(){

    var optiondata;
    $.ajax({
        cache: true,
        contentType: "application/json",
        dataType: "json",
        type: "GET",
        url: "/statistics/dimension/enterprise/type",
        async: false,
        error: function (request) {
            $.modal.alertError("系统错误");
        },
        success: function (data) {
            optiondata = data
        }
    });

    var colorList = ['#0bff84', '#db5200', '#fad400', '#FDB36A', '#FD866A', '#9E87FF', '#58D5FF']
    var option = {
        tooltip: {
            trigger: 'item'
        },
        series: [{
            type: 'pie',
            center: ['55%', '50%'],
            radius: ['35%', '50%'],
            clockwise: true,
            avoidLabelOverlap: true,
            hoverOffset: 15,
            itemStyle: {
                normal: {
                    color: function(params) {
                        return colorList[params.dataIndex]
                    },
                    borderColor: '#28344c',
                    borderWidth: 4
                }
            },
            label: {
                show: true,
                position: 'outside',
                formatter: '{a|{b}：}\n{c|{d}%}\n{hr|}',
                rich: {
                    hr: {
                        backgroundColor: 't',
                        borderRadius: 3,
                        width: 3,
                        height: 3,
                        padding: [3, 3, 0, -12],
                        color: '#00ffe4'
                    },
                    a: {
                        padding: [-30, 0, -20, 5],
                        color: '#02eeff',
                        fontSize: 14
                    },
                    c: {
                        padding: [-70, 20, -20, 0],
                        color: '#02eeff',
                        fontSize: 14
                    }
                }
            },
            labelLine: {
                normal: {
                    length: 20,
                    length2: 30,
                    lineStyle: {
                        width: 1,
                        color: '#00ffe4',
                        type: 'dashed'
                    },
                }
            },
            data: optiondata,
        }]
    };
    var mychart1 = echarts.init(document.getElementById("Y127_echart1"));
    mychart1.setOption(option);
    window.addEventListener("resize", function() {
        mychart1.resize();
    });
})
