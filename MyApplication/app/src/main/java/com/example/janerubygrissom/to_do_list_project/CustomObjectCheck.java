package com.example.janerubygrissom.to_do_list_project;

/**
 * Created by janerubygrissom on 7/5/16.
 */
public class CustomObjectCheck {

               private String mTitle;
        private String mDescription;
        private String mColor;
        private boolean mSelected;

                public CustomObjectCheck() {
                this.mTitle = "Title Text";
               this.mDescription = "Description Text";
               this.mColor = "#6200EA";
                this.mSelected = false;

                   }

                public CustomObjectCheck(String mTitle, String mDescription, String mColor, boolean mSelected) {
                this.mTitle = mTitle;
                this.mDescription = mDescription;
                this.mColor = mColor;
                this.mSelected = mSelected;

                    }

               public String getTitle() {
                return mTitle;
            }

                public void setTitle(String mTitle) {
                this.mTitle = mTitle;
            }

                public String getDescription() {
                return mDescription;
            }

                public void setDescription(String mDescription) {
               this.mDescription = mDescription;
            }

                public String getColor() {
                return mColor;
           }

                public void setColor(String mColor) {
               this.mColor = mColor;
            }

                public boolean isSelected() {
                return mSelected;
            }

               public void setSelected(boolean mSelected) {
                this.mSelected = mSelected;
            }
    }
