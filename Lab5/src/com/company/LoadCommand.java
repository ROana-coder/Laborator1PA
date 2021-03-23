package com.company;

public class LoadCommand extends Command{
public void load(Catalog catalog, String path)
{
    catalog = CatalogUtil.load(path);
}
}
