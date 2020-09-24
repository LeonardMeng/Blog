<!--
  Created by KanadeM on 2020/9/24
-->
<template>
  <div id="visit-pie-chart" class="visit-pie-chart"></div>
</template>

<script>
  import echarts from 'echarts'
  export default {
    name: "pie-chart",
    data() {
      return {
        chart: null
      }
    },
    mounted() {
      this.initChart()
    },
    methods: {
      initChart() {
        this.chart = echarts.init(document.getElementById('visit-pie-chart'))

        this.chart.setOption({
          tooltip: {
            trigger: 'item',
            formatter: '{a} <br/>{b} : {c} ({d}%)'
          },
          legend: {
            left: 'center',
            bottom: '10',
            data: ['Industries', 'Technology', 'Forex', 'Gold', 'Forecasts']
          },
          series: [
            {
              name: 'WEEKLY WRITE ARTICLES',
              type: 'pie',
              roseType: 'radius',
              radius: [15, 95],
              center: ['50%', '38%'],
              data: [
                { value: 320, name: 'Industries' },
                { value: 240, name: 'Technology' },
                { value: 149, name: 'Forex' },
                { value: 100, name: 'Gold' },
                { value: 59, name: 'Forecasts' }
              ],
              animationEasing: 'cubicInOut',
              animationDuration: 2600
            }
          ]
        })
      }
    }
  }
</script>

<style scoped>
.visit-pie-chart {
  margin-top: 5%;
  width: 90%;
  height: 90%;
}
</style>
