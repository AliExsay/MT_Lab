package com.example.lab1;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class GridAdapter extends BaseAdapter {
    private Context context;
    private int rows, cols;
    private String pictureCollection;
    private ArrayList<String> pictures;
    private Resources resources;
    private enum Status {CELL_OPEN, CELL_CLOSE, CELL_DELETE};
    private ArrayList<Status> cellStatus;
    private ArrayList<Integer> openedMatchingCells = new ArrayList<>();
    private int openCellPosition = -1;

    public GridAdapter(Context context, int rows, int cols) {
        this.context = context;
        this.rows = rows;
        this.cols = cols;

        pictureCollection = "fruit";
        pictures = new ArrayList<>();
        cellStatus = new ArrayList<>();
        resources = context.getResources();

        makePictArray();
        closeAllCells();
    }

    private void makePictArray() {
        pictures.clear();
        for (int i = 0; i < rows * cols / 2; i++) {
            pictures.add(pictureCollection + i);
            pictures.add(pictureCollection + i);
        }
        Collections.shuffle(pictures);
    }

    private void closeAllCells() {
        cellStatus.clear();
        for (int i = 0; i < rows * cols; i++) {
            cellStatus.add(Status.CELL_CLOSE);
        }
    }

    public void checkOpenCells() {
        int first = cellStatus.indexOf(Status.CELL_OPEN);
        int second = cellStatus.lastIndexOf(Status.CELL_OPEN);

        if (first == second || first == -1 || second == -1) {
            return;
        }

        if (pictures.get(first).equals(pictures.get(second)) && first != -1 && second != -1) {
            cellStatus.set(first, Status.CELL_DELETE);
            cellStatus.set(second, Status.CELL_DELETE);
        } else {
            cellStatus.set(first, Status.CELL_CLOSE);
            cellStatus.set(second, Status.CELL_CLOSE);
        }

        openCellPosition = -1; // Сброс открытой ячейки
        notifyDataSetChanged();
    }

    public boolean openCell(int position) {
        Status currentCellStatus = cellStatus.get(position);

        if (currentCellStatus == Status.CELL_DELETE) {
            return false;
        }

        // Если уже есть открытые ячейки, не открываем новую
        if (openedMatchingCells.size() >= 2) {
            return false;
        }

        // Закрыть любую открытую ячейку перед открытием новой
        if (openCellPosition != -1 && openCellPosition != position) {
            cellStatus.set(openCellPosition, Status.CELL_CLOSE);
        }

        if (currentCellStatus == Status.CELL_OPEN) {
            // Если ячейка уже открыта, закрыть её
            cellStatus.set(position, Status.CELL_CLOSE);
            openCellPosition = -1;
        } else {
            // Если нет открытых ячеек, открыть выбранную
            cellStatus.set(position, Status.CELL_OPEN);
            openCellPosition = position;
        }

        // Добавить индекс открытой ячейки в список
        openedMatchingCells.add(position);

        // Если открыто две ячейки, проверить совпадение фотографий
        if (openedMatchingCells.size() == 2) {
            int first = openedMatchingCells.get(0);
            int second = openedMatchingCells.get(1);

            if (pictures.get(first).equals(pictures.get(second)) && first != -1 && second != -1) {
                cellStatus.set(first, Status.CELL_DELETE);
                cellStatus.set(second, Status.CELL_DELETE);
            }

            // Очистить список открытых ячеек
            openedMatchingCells.clear();
        }

        notifyDataSetChanged();
        return true;
    }




    public boolean checkGameOver() {
        return !cellStatus.contains(Status.CELL_CLOSE);
    }

    @Override
    public int getCount() {
        return rows * cols;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView view;

        if (convertView == null) {
            view = new ImageView(context);
        } else {
            view = (ImageView)convertView;
        }

        switch (cellStatus.get(position)) {
            case CELL_OPEN:
                int drawableId = resources.getIdentifier(pictures.get(position), "drawable", context.getPackageName());
                view.setImageResource(drawableId);
                break;
            case CELL_CLOSE:
                view.setImageResource(R.drawable.close_cell);
                break;
            default:
                view.setImageResource(R.drawable.none);
        }

        return view;
    }
}
