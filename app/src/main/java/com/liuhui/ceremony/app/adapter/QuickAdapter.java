package com.liuhui.ceremony.app.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: berial
 * date: 15/4/20.
 */
public abstract class QuickAdapter<T> extends BaseAdapter {

	private List<T> mObjects;

	private int mLayoutRes;

	public QuickAdapter(int layoutRes, List<T> data) {
		this.mObjects = data;
		this.mLayoutRes = layoutRes;
	}

	public QuickAdapter(int layoutRes) {
		this.mLayoutRes = layoutRes;
	}

	public void addAll(List<T> data) {
		if(mObjects == null) {
			mObjects = data;
		} else {
			mObjects.addAll(data);
		}
		notifyDataSetChanged();
	}

	public void add(int position, T obj) {
		if(mObjects == null) {
			mObjects = new ArrayList<>();
		}
		mObjects.add(position, obj);
		notifyDataSetChanged();
	}

	public void add(T obj) {
		if(mObjects == null) {
			mObjects = new ArrayList<>();
		}
		mObjects.add(obj);
		notifyDataSetChanged();
	}

	public void remove(T obj) {
		if(mObjects != null) {
			mObjects.remove(obj);
		}
		notifyDataSetChanged();
	}

	public void remove(int position) {
		if(mObjects != null) {
			mObjects.remove(position);
		}
		notifyDataSetChanged();
	}

	public void clear() {
		if(mObjects != null) {
			mObjects.clear();
		}
		notifyDataSetChanged();
	}

	@Override
	public int getCount() {
		return mObjects != null ? mObjects.size() : 0;
	}

	@Override
	public T getItem(int position) {
		return mObjects.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = ViewHolder.bind(parent.getContext(), convertView, parent, mLayoutRes
				, position);
		bindView(holder, getItem(position));
		return holder.getItemView();
	}

	public abstract void bindView(ViewHolder holder, T obj);

	public static class ViewHolder {

		private SparseArray<View> mViews;

		private View item;

		private int position;

		private Context context;

		private ViewHolder(Context context, ViewGroup parent, int layoutRes) {
			mViews = new SparseArray<>();
			this.context = context;
			View convertView = LayoutInflater.from(context).inflate(layoutRes, parent, false);
			convertView.setTag(this);
			item = convertView;
		}

		/**
		 * 建立ViewHolder与item的关系
		 */
		public static ViewHolder bind(Context context, View convertView, ViewGroup parent,
		                              int layoutRes, int position) {
			ViewHolder holder;
			if(convertView == null) {
				holder = new ViewHolder(context, parent, layoutRes);
			} else {
				holder = (ViewHolder) convertView.getTag();
				holder.item = convertView;
			}
			holder.position = position;
			return holder;
		}

		@SuppressWarnings("unchecked")
		public <T extends View> T getView(int id) {
			T t = (T) mViews.get(id);
			if(t == null) {
				t = (T) item.findViewById(id);
				mViews.put(id, t);
			}
			return t;
		}

		/**
		 * 获取当前条目
		 */
		public View getItemView() {
			return item;
		}

		/**
		 * 获取条目位置
		 */
		public int getItemPosition() {
			return position;
		}

		/**
		 * 设置文字
		 */
		public ViewHolder setText(int id, CharSequence text) {
			View view = getView(id);
			if(view instanceof TextView) {
				((TextView) view).setText(text);
			}
			return this;
		}

		/**
		 * 设置图片
		 */
		public ViewHolder setImageResource(int id, int drawableRes) {
			View view = getView(id);
			if(view instanceof ImageView) {
				Glide.with(context).load(drawableRes).into((ImageView) view);
			} else {
				view.setBackgroundResource(drawableRes);
			}
			return this;
		}

		public ViewHolder setImageUrl(int id, String url) {
			View view = getView(id);
			if(view instanceof ImageView) {
				Glide.with(context).load(url).into((ImageView) view);
			}
			return this;
		}

		/**
		 * 设置点击监听
		 */
		public ViewHolder setOnClickListener(int id, View.OnClickListener listener) {
			getView(id).setOnClickListener(listener);
			return this;
		}

		/**
		 * 设置可见
		 */
		public ViewHolder setVisibility(int id, int visible) {
			getView(id).setVisibility(visible);
			return this;
		}

		/**
		 * 设置标签
		 */
		public ViewHolder setTag(int id, Object obj) {
			getView(id).setTag(obj);
			return this;
		}

		// TODO 常用方法可以自行拓展
	}
}
