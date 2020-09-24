<!--
  Created by KanadeM on 2020/9/23
-->
<template>
  <div class="dashboard-container">
    <div class="panel-group">
      <panel-group></panel-group>
    </div>
    <div class="line-chart">
      <line-chart :chartData="lineChartData"></line-chart>
    </div>
    <div class="visits-info">
      <div class="visits-detail">
        <visits-detail-table :visitDetail="visitDetail"></visits-detail-table>
      </div>

      <div class="visits-chart">
        <pie-chart></pie-chart>
      </div>
    </div>

  </div>
</template>

<script>
  import PanelGroup from "./components/panel-group";
  import LineChart from "./components/line-chart";
  import VisitsDetailTable from "./components/visits-detail-table";
  import PieChart from "./components/pie-chart";

  export default {
    name: "index",
    components: {PieChart, VisitsDetailTable, LineChart, PanelGroup},
    data() {
      return {
        lineChartData: {
          expectedData: [100, 120, 161, 134, 105, 160, 165],
          actualData: [120, 82, 91, 154, 162, 140, 145]
        },
        visitDetail: [{
          ip: '192.168.1.1',
          option: 'Login',
          status: 'Success'
        }, {
          ip: '192.168.1.1',
          option: 'Login',
          status: 'Success'
        }, {
          ip: '192.168.1.1',
          option: 'Login',
          status: 'Success'
        }, {
          ip: '192.168.1.1',
          option: 'Click Something',
          status: 'Exception Catched'
        }]
      }
    }
  }
</script>

<style scoped>
  .dashboard-container {
    width: 100%;
    height: 100%;
    background: #eef1f4;

  }

  .panel-group {
    padding-top: 0.5%;
    height: 10%;
  }

  .line-chart {
    margin-top: 2.5%;
    height: 40%;

  }
  .visits-info{
    padding-left: 5%;
    width: 90%;
    margin-top: 1.5%;
    height: 40%;
  }
  .visits-detail {
    float: left;
    width: 70%;
    height: 100%;
    background: white;
  }
  .visits-chart {
    float: left;
    width: 30%;
    height: 100%;
    background: white;
  }

</style>
