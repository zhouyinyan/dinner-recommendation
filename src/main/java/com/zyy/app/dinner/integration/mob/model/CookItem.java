package com.zyy.app.dinner.integration.mob.model;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * Created by zhouyinyan on 2019/3/29.
 */
public class CookItem implements Serializable {

    private List<String> ctgIds;

    private String ctgTitles;

    private String menuId;

    private String name;

    private Recipe recipe;

    private String thumbnail;

    public List<String> getCtgIds() {
        return ctgIds;
    }

    public void setCtgIds(List<String> ctgIds) {
        this.ctgIds = ctgIds;
    }

    public String getCtgTitles() {
        return ctgTitles;
    }

    public void setCtgTitles(String ctgTitles) {
        this.ctgTitles = ctgTitles;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CookItem{");
        sb.append("ctgIds=").append(ctgIds);
        sb.append(", ctgTitles='").append(ctgTitles).append('\'');
        sb.append(", menuId='").append(menuId).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", recipe=").append(recipe);
        sb.append(", thumbnail='").append(thumbnail).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public static class Recipe implements Serializable{

        private String title;

        private String sumary;

        private String img;

        private String ingredients;

        private List<Step> steps;

        private String method;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSumary() {
            return sumary;
        }

        public void setSumary(String sumary) {
            this.sumary = sumary;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getIngredients() {
            return ingredients;
        }

        public void setIngredients(String ingredients) {
            this.ingredients = ingredients;
        }

        public List<Step> getSteps() {
            if(Objects.isNull(steps)){
                try {
                    steps = new ObjectMapper().readValue(method, List.class);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return steps;
        }

        public void setSteps(List<Step> steps) {
            this.steps = steps;
        }

        public String getMethod() {
            return method;
        }

        public void setMethod(String method) {
            this.method = method;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("Recipe{");
            sb.append("title='").append(title).append('\'');
            sb.append(", sumary='").append(sumary).append('\'');
            sb.append(", img='").append(img).append('\'');
            sb.append(", ingredients='").append(ingredients).append('\'');
            sb.append(", steps=").append(getSteps());
            sb.append(", method='").append(method).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }

    public static class Step implements Serializable {
        private String img;

        private String step;

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("Step{");
            sb.append("img='").append(img).append('\'');
            sb.append(", step='").append(step).append('\'');
            sb.append('}');
            return sb.toString();
        }

        public String getStep() {
            return step;
        }

        public void setStep(String step) {
            this.step = step;
        }
    }
}
