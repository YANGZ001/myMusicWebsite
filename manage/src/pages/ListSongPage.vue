<template>
  <div class="table">
    <div class="crumbs">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item>
          <i class="el-icon-tickets"></i> List song Information
        </el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div class="container">
      <div class="handle-box">
        <el-button type="primary" size="mini" class="handle-del mr10" @click="delAll">Delete in batch</el-button>
        <el-input v-model="select_word" size="mini" placeholder="筛选关键词" class="handle-input mr10"></el-input>
        <el-button type="primary" size="mini" @click="centerDialogVisible = true">Add new song</el-button>
      </div>
      <el-table
        :data="tableData"
        border
        size="mini"
        style="width: 100%"
        ref="multipleTable"
        @selection-change="handleSelectionChange"
      >
        <el-table-column type="selection" width="50"></el-table-column>
        <el-table-column prop="name" label="歌手-歌曲"></el-table-column>
        <el-table-column label="操作" width="80">
          <template slot-scope="scope">
            <el-button size="small" type="danger" @click="handleDelete(scope.row.id)">Delete</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>

    <!--添加歌曲-->
    <el-dialog title="添加歌曲" :visible.sync="centerDialogVisible" width="400px" center>
      <el-form
        :model="registerForm"
        status-icon
        ref="registerForm"
        label-width="80px"
        class="demo-ruleForm"
      >
        <el-form-item prop="singerName" label="歌手名字" size="mini">
          <el-input v-model="registerForm.singerName" placeholder="歌手名字"></el-input>
        </el-form-item>
        <el-form-item prop="songName" label="歌曲名字" size="mini">
          <el-input v-model="registerForm.songName" placeholder="歌曲名字"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button size="mini" @click="centerDialogVisible = false">No</el-button>
        <el-button type="primary" size="mini" @click="getSongId">Yes</el-button>
      </span>
    </el-dialog>

    <!-- 删除提示框 -->
    <el-dialog title="提示" :visible.sync="delVisible" width="300px" center>
      <div class="del-dialog-cnt" align="center">Deleting can not be redo, sure?</div>
      <span slot="footer" class="dialog-footer">
        <el-button size="mini" @click="delVisible = false">No</el-button>
        <el-button type="primary" size="mini" @click="deleteRow">Yes</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import { mixin } from '../mixins'
import { HttpManager } from '../api/index'

export default {
  name: 'list-song-page',
  mixins: [mixin],
  data () {
    return {
      registerForm: {
        singerName: '',
        songName: ''
      },
      tableData: [],
      tempDate: [],
      multipleSelection: [],
      centerDialogVisible: false,
      editVisible: false,
      delVisible: false,
      select_word: '',
      idx: -1
    }
  },
  watch: {
    select_word: function () {
      if (this.select_word === '') {
        this.tableData = this.tempDate
      } else {
        this.tableData = []
        for (let item of this.tempDate) {
          if (item.name.includes(this.select_word)) {
            this.tableData.push(item)
          }
        }
      }
    }
  },
  created () {
    this.getData()
  },
  methods: {
    // 获取歌单
    getData () {
      this.tableData = []
      this.tempDate = []
      HttpManager.getListSongOfSongId(this.$route.query.id)
        .then(res => {
          console.log(res)
          for (let item of res) {
            this.getSong(item.songId)
          }
        })
        .catch(err => {
          console.log(err)
        })
    },
    // 获取歌单里对应的音乐
    getSong (id) {
      HttpManager.getSongOfId(id)
        .then(res => {
          this.tableData.push(res[0])
          this.tempDate.push(res[0])
        })
        .catch(err => {
          console.log(err)
        })
    },
    // 获取要添加歌曲的ID
    getSongId () {
      let _this = this
      var id = _this.registerForm.singerName + '-' + _this.registerForm.songName
      HttpManager.getSongOfSingerName(id)
        .then(res => {
          this.addSong(res[0].id)
        })
    },
    // 添加歌曲
    addSong (id) {
      let params = new URLSearchParams()
      params.append('songId', id)
      params.append('songListId', this.$route.query.id)
      HttpManager.setListSong(params)
        .then(res => {
          if (res.code === 1) {
            this.getData()
            this.notify('Add successful', 'success')
          } else {
            this.notify('Add failed', 'error')
          }
        })
        .catch(err => {
          console.log(err)
        })
      this.centerDialogVisible = false
    },
    // 确定删除
    deleteRow () {
      HttpManager.deleteListSong(this.idx)
        .then(res => {
          if (res) {
            this.getData()
            this.notify('Delete successful', 'success')
          } else {
            this.notify('Delete failed', 'error')
          }
        })
        .catch(err => {
          console.log(err)
        })
      this.delVisible = false
    }
  }
}
</script>

<style scoped>
.handle-box {
  margin-bottom: 20px;
}

.handle-input {
  width: 300px;
  display: inline-block;
}
</style>
