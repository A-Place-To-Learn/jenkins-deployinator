package com.etsy.jenkins;

import hudson.Extension;
import hudson.model.Run;
import hudson.views.ListViewColumn;
import hudson.views.ListViewColumnDescriptor;

import org.kohsuke.stapler.DataBoundConstructor;

public class StageNumberColumn extends ListViewColumn {

  @DataBoundConstructor
  public StageNumberColumn() {}

  @Override
  public String getColumnCaption() {
    return "";
  }

  public static int getStageNumber(Run run) {
    StageNumberJobProperty prop = (StageNumberJobProperty)
        run.getParent().getProperty(StageNumberJobProperty.class);
    if (prop == null) {
      return 0;
    }

    return prop.getStageNumber();
  }

  @Extension
  public static class DescriptorImpl extends ListViewColumnDescriptor {

    @Override
    public String getDisplayName() {
      return "Deployinator Stage";
    }

    @Override
    public boolean shownByDefault() {
      return false;
    }
  }
}

