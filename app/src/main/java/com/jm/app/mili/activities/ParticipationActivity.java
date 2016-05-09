package com.jm.app.mili.activities;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;


import com.jm.app.mili.Bean.ParticipationBean;
import com.jm.app.mili.R;

import java.util.ArrayList;
import java.util.List;

//参与
public class ParticipationActivity extends Activity {
    private ExpandableListView expandableListView;
    private MyExpandableListViewAdapter adapter;
    private ArrayList<ParticipationBean> list;
    private List<String> group_list;

    private List<String> item_lt;

    private List<List<String>> item_list;

    private List<List<String>> item_list2;

    private List<List<String>> gr_list2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_participation);
        // 随便一堆测试数据
        group_list = new ArrayList<String>();
        group_list.add("1");
        group_list.add("45");
        group_list.add("100");
        group_list.add("99");

        item_lt = new ArrayList<String>();
        item_lt.add("1111");
        item_lt.add("2222");
        item_lt.add("3333");

        item_list = new ArrayList<List<String>>();
        item_list.add(item_lt);
        item_list.add(item_lt);
        item_list.add(item_lt);
        item_list.add(item_lt);

        List<String> tmp_list = new ArrayList<String>();
        tmp_list.add("aasas");


        item_list2 = new ArrayList<List<String>>();
        item_list2.add(tmp_list);

        List<String> gr_list = new ArrayList<String>();
        gr_list.add("bbbbb");

        gr_list2 = new ArrayList<List<String>>();
        gr_list2.add(gr_list);
        expandableListView = (ExpandableListView) findViewById(R.id.expendlist);
        expandableListView.setGroupIndicator(null);

        // 监听组点击
        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                if (item_list.get(groupPosition).isEmpty()) {
                    return true;
                }
                return false;
            }
        });

        // 监听每个分组里子控件的点击事件
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                Toast.makeText(ParticipationActivity.this, "group=" + groupPosition + "---child=" + childPosition + "---" + item_list.get(groupPosition).get(childPosition), Toast.LENGTH_SHORT).show();

                return false;
            }
        });

        adapter = new MyExpandableListViewAdapter(this);

        expandableListView.setAdapter(adapter);
    }

    // 用过ListView的人一定很熟悉，只不过这里是BaseExpandableListAdapter
    class MyExpandableListViewAdapter extends BaseExpandableListAdapter {

        private Context context;

        public MyExpandableListViewAdapter(Context context) {
            this.context = context;
        }

        /**
         * 获取组的个数
         *
         * @return
         * @see android.widget.ExpandableListAdapter#getGroupCount()
         */
        @Override
        public int getGroupCount() {
            return group_list.size();
        }

        /**
         * 获取指定组中的子元素个数
         *
         * @param groupPosition
         * @return
         * @see android.widget.ExpandableListAdapter#getChildrenCount(int)
         */
        @Override
        public int getChildrenCount(int groupPosition) {
            return item_list.get(groupPosition).size();
        }

        /**
         * 获取指定组中的数据
         *
         * @param groupPosition
         * @return
         * @see android.widget.ExpandableListAdapter#getGroup(int)
         */
        @Override
        public Object getGroup(int groupPosition) {
            return group_list.get(groupPosition);
        }

        /**
         * 获取指定组中的指定子元素数据。
         *
         * @param groupPosition
         * @param childPosition
         * @return
         * @see android.widget.ExpandableListAdapter#getChild(int, int)
         */
        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return item_list.get(groupPosition).get(childPosition);
        }

        /**
         * 获取指定组的ID，这个组ID必须是唯一的
         *
         * @param groupPosition
         * @return
         * @see android.widget.ExpandableListAdapter#getGroupId(int)
         */
        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        /**
         * 获取指定组中的指定子元素ID
         *
         * @param groupPosition
         * @param childPosition
         * @return
         * @see android.widget.ExpandableListAdapter#getChildId(int, int)
         */
        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        /**
         * 组和子元素是否持有稳定的ID,也就是底层数据的改变不会影响到它们。
         *
         * @return
         * @see android.widget.ExpandableListAdapter#hasStableIds()
         */
        @Override
        public boolean hasStableIds() {
            return true;
        }

        /**
         * 获取显示指定组的视图对象
         *
         * @param groupPosition 组位置
         * @param isExpanded    该组是展开状态还是伸缩状态
         * @param convertView   重用已有的视图对象
         * @param parent        返回的视图对象始终依附于的视图组
         * @return
         * @see android.widget.ExpandableListAdapter#getGroupView(int, boolean, View,
         * ViewGroup)
         */
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
            GroupHolder groupHolder = null;
            if (convertView == null) {
                convertView = LayoutInflater.from(context).inflate(R.layout.item_listview1, null);
                groupHolder = new GroupHolder();
                groupHolder.name = (TextView) convertView.findViewById(R.id.txt);
                groupHolder.set = (TextView) convertView.findViewById(R.id.txt2);
                convertView.setTag(groupHolder);
            } else {
                groupHolder = (GroupHolder) convertView.getTag();
            }

            if (!isExpanded) {
                groupHolder.set.setText("大开");
            } else {
                groupHolder.set.setText("关闭");
            }

            groupHolder.name.setText(group_list.get(groupPosition));
            return convertView;
        }

        /**
         * 获取一个视图对象，显示指定组中的指定子元素数据。
         *
         * @param groupPosition 组位置
         * @param childPosition 子元素位置
         * @param isLastChild   子元素是否处于组中的最后一个
         * @param convertView   重用已有的视图(View)对象
         * @param parent        返回的视图(View)对象始终依附于的视图组
         * @return
         * @see android.widget.ExpandableListAdapter#getChildView(int, int, boolean, View,
         * ViewGroup)
         */
        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            ItemHolder itemHolder = null;
            if (convertView == null) {
                convertView = LayoutInflater.from(context).inflate(R.layout.item_listview2, null);
                itemHolder = new ItemHolder();
                itemHolder.tv1 = (TextView) convertView.findViewById(R.id.tv1);
                itemHolder.tv2 = (TextView) convertView.findViewById(R.id.tv2);
                itemHolder.tv3 = (TextView) convertView.findViewById(R.id.tv3);
                itemHolder.tv4 = (TextView) convertView.findViewById(R.id.tv4);
                convertView.setTag(itemHolder);
            } else {
                itemHolder = (ItemHolder) convertView.getTag();
            }
            itemHolder.tv1.setText(item_list.get(groupPosition).get(childPosition));
            itemHolder.tv2.setText(item_list.get(groupPosition).get(childPosition));
            itemHolder.tv3.setText(item_list.get(groupPosition).get(childPosition));
            itemHolder.tv4.setText(item_list.get(groupPosition).get(childPosition));
            return convertView;
        }

        /**
         * 是否选中指定位置上的子元素。
         *
         * @param groupPosition
         * @param childPosition
         * @return
         * @see android.widget.ExpandableListAdapter#isChildSelectable(int, int)
         */
        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }

    }

    class GroupHolder {
        public TextView name, nuber, set;

    }

    class ItemHolder {

        public TextView tv1, tv2, tv3, tv4;
    }
}
