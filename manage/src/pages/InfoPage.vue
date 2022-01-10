<template>
  <div>
    <el-row :gutter="20" class="mgb20">
      <el-col :span="6">
        <el-card shadow="hover" :body-style="{padding: '0px'}">
          <div class="grid-content grid-con-1">
            <div class="grid-cont-right">
              <div class="grid-num">{{userCount}}</div>
              <div>Total users</div>
            </div>
          </div>
        </el-card>
      </el-col>
      <el-col :span="6">
        <el-card shadow="hover" :body-style="{padding: '0px'}">
          <div class="grid-content grid-con-2">
            <div class="grid-cont-right">
              <div class="grid-num">{{songCount}}</div>
              <div>Total songs</div>
            </div>
          </div>
        </el-card>
      </el-col>
      <el-col :span="6">
        <el-card shadow="hover" :body-style="{padding: '0px'}">
          <div class="grid-content grid-con-3">
            <div class="grid-cont-right">
              <div class="grid-num">{{singerCount}}</div>
              <div>Total singers</div>
            </div>
          </div>
        </el-card>
      </el-col>
      <el-col :span="6">
        <el-card shadow="hover" :body-style="{padding: '0px'}">
          <div class="grid-content grid-con-4">
            <div class="grid-cont-right">
              <div class="grid-num">{{songListCount}}</div>
              <div>Total song lists</div>
            </div>
          </div>
        </el-card>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <h3 style="margin-bottom: 20px">User gender ratio</h3>
        <div class="cav-info" style="background-color: white">
          <ve-pie :data="userSex" :theme="options"></ve-pie>
        </div>
      </el-col>
      <el-col :span="12">
        <h3 style="margin-bottom: 20px">Song catagory distribution</h3>
        <div class="cav-info" style="background-color: white">
          <ve-histogram :data="songStyle" :theme="options3"></ve-histogram>
        </div>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <h3 style="margin: 20px 0">Singer gender ratio</h3>
        <div class="cav-info" style="background-color: white">
          <ve-pie :data="singerSex" :theme="options1"></ve-pie>
        </div>
      </el-col>
      <el-col :span="12">
        <h3 style="margin: 20px 0">Singer nationality distribution</h3>
        <div class="cav-info" style="background-color: white">
          <ve-histogram :data="country" :theme="options2"></ve-histogram>
        </div>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import { mixin } from '../mixins'
import { HttpManager } from '../api/index'

export default {
  mixins: [mixin],
  data () {
    return {
      user: [],
      userSex: {
        columns: ['Gender', 'Total'],
        rows: [
          { 'Gender': 'Male', 'Total': 0 },
          { 'Gender': 'Female', 'Total': 0 }
        ]
      },
      singerSex: {
        columns: ['Gender', 'Total'],
        rows: [
          { 'Gender': 'Male', 'Total': 0 },
          { 'Gender': 'Female', 'Total': 0 }
        ]
      },
      country: {
        columns: ['Country', 'Total'],
        rows: [
          { 'Country': 'China', 'Total': 0 },
          { 'Country': 'Korea', 'Total': 0 },
          { 'Country': 'Italy', 'Total': 0 },
          { 'Country': 'Singapore', 'Total': 0 },
          { 'Country': 'America', 'Total': 0 },
          { 'Country': 'Malaysia', 'Total': 0 },
          { 'Country': 'Spain', 'Total': 0 },
          { 'Country': 'Japan', 'Total': 0 }
        ]
      },
      options: {
        color: ['#87CEFA', '#FFC0CB']
      },
      options1: {
        color: ['#1E90FF', '#7B68EE']
      },
      options2: {
        color: ['#FEED78'],
        tooltip: {
          trigger: 'axis',
          axisPointer: { // 坐标轴指示器，坐标轴触发有效
            type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
          }
        },
        grid: {
          left: '3%',
          right: '4%',
          bottom: '3%',
          containLabel: true
        }
      },
      options3: {
        color: ['#FD8A61'],
        tooltip: {
          trigger: 'axis',
          axisPointer: { // 坐标轴指示器，坐标轴触发有效
            type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
          }
        },
        grid: {
          left: '3%',
          right: '4%',
          bottom: '3%',
          containLabel: true
        }
      },
      songStyle: {
        columns: ['Division', 'Total'],
        rows: [
          { 'Division': 'Chinese', 'Total': 0 },
          { 'Division': 'Cantonese', 'Total': 0 },
          { 'Division': 'English', 'Total': 0 },
          { 'Division': 'Korean pop', 'Total': 0 },
          { 'Division': 'BGM', 'Total': 0 },
          { 'Division': 'Soft music', 'Total': 0 },
          { 'Division': 'Instruments', 'Total': 0 }
        ]
      },
      userCount: 0,
      songCount: 0,
      singerCount: 0,
      songListCount: 0
    }
  },
  mounted () {
    this.getUser()
    this.getSinger()
    this.getSong()
    this.getSongList()
  },
  methods: {
    getUser () {
      HttpManager.getAllUser().then(res => {
        this.userCount = res.length
        this.userSex.rows[0]['Total'] = this.setSex(1, res)
        this.userSex.rows[1]['Total'] = this.setSex(0, res)
      })
    },
    setSex (sex, arr) {
      let count = 0
      for (let item of arr) {
        if (sex === item.sex) {
          count++
        }
      }
      return count
    },
    getCountry (val) {
      for (let item of this.country.rows) {
        if (val.includes(item['Country'])) {
          item['Total']++
          break
        }
      }
    },
    getStyle (val) {
      for (let item of this.songStyle.rows) {
        if (val.includes(item['Division'])) {
          item['Total']++
        }
      }
    },
    getSinger () {
      HttpManager.getAllSinger().then(res => {
        this.singerCount = res.length
        this.singerSex.rows[0]['Total'] = this.setSex(1, res)
        this.singerSex.rows[1]['Total'] = this.setSex(0, res)
        for (let item of res) {
          this.getCountry(item.location)
        }
      }).catch(err => {
        console.log(err)
      })
    },
    getSong () {
      HttpManager.getAllSong().then(res => {
        this.songCount = res.length
      }).catch(err => {
        console.log(err)
      })
    },
    getSongList () {
      HttpManager.getSongList().then(res => {
        this.songListCount = res.length
        for (let item of res) {
          this.getStyle(item.style)
        }
      }).catch(err => {
        console.log(err)
      })
    }
  }
}
</script>

<style>
  .grid-content {
    display: flex;
    align-items: center;
    height: 100px;
  }

  .grid-cont-right {
    flex: 1;
    text-align: center;
    font-size: 14px;
    color: #999;
  }

  .grid-num {
    font-size: 30px;
    font-weight: bold;
  }

  .cav-info {
    border-radius: 6px;
    overflow: hidden;
  }
</style>
